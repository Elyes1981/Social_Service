package com.example.demopfecamunda.controller;

import com.example.demopfecamunda.model.UserTaskStatusDto;
import com.example.demopfecamunda.provider.model.User;
import com.example.demopfecamunda.provider.service.UserService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.history.HistoricTaskInstance;
import org.camunda.bpm.engine.history.HistoricTaskInstanceQuery;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.task.Comment;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.instance.UserTask;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/process/initiate")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE})


public class ProcessRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessRestController.class);

    @Value("${spring.workflow.keydefinitionname}")
    private String keyDefinition ;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    UserService userService;

    @GetMapping("/getListTask")
    public ResponseEntity<Collection<UserTaskStatusDto>> getWorkfloTaskList(@RequestParam(value = "id") Long id){
        User user =userService.findUserById(id);
        ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService =processEngine.getRepositoryService();
        UserTaskStatusDto userTaskStatusDto;
        Collection<UserTaskStatusDto> userTaskStatusDtoList ;


        // id user + task information
        Map<String, UserTaskStatusDto> userTaskStatusDtoMap = new LinkedHashMap<>();

        final List list =repositoryService.createProcessDefinitionQuery().processDefinitionKey(keyDefinition).latestVersion().list();

        final String processDefinitionId = ((ProcessDefinition) list.get(0)).getId();
        LOGGER.info("processDefinitionId: "+processDefinitionId);

        BpmnModelInstance bpmnModelInstance = repositoryService.getBpmnModelInstance(processDefinitionId);
        Collection<UserTask> userTasks = bpmnModelInstance.getModelElementsByType(UserTask.class);

        for (UserTask userTask : userTasks) {
            userTaskStatusDto = new UserTaskStatusDto();
            userTaskStatusDto.setUserTaskName(userTask.getName());
            userTaskStatusDto.setProfileName(userTask.getCamundaAssignee());
            userTaskStatusDto.setCandidateUser(userTask.getCamundaCandidateUsers());
            userTaskStatusDtoMap.put(userTask.getId(), userTaskStatusDto);
        }

        HistoricTaskInstanceQuery historicTaskInstanceQuery = processEngine.getHistoryService().createHistoricTaskInstanceQuery();
        List<HistoricTaskInstance> historicTaskInstanceList = historicTaskInstanceQuery
                .processInstanceId(user.getProcessInstanceID())
                .list();
        for (HistoricTaskInstance historicTaskInstance : historicTaskInstanceList) {

            if (userTaskStatusDtoMap.containsKey(historicTaskInstance.getTaskDefinitionKey())) {
                userTaskStatusDto = userTaskStatusDtoMap.get(historicTaskInstance.getTaskDefinitionKey());
                userTaskStatusDto.setStartTime(new DateTime(historicTaskInstance.getStartTime()).toString("dd/MM/yyyy HH:mm:ss"));
                if(historicTaskInstance.getEndTime() != null){
                    userTaskStatusDto.setEndTime(new DateTime(historicTaskInstance.getEndTime()).toString("dd/MM/yyyy HH:mm:ss"));
                }
                userTaskStatusDto.setDeleteReason(historicTaskInstance.getDeleteReason());
                userTaskStatusDto.setAuthorized(true);
                //userTaskStatusDto.setDecision(true);
                List<Comment> comments = processEngine.getTaskService().getTaskComments(historicTaskInstance.getId());
                if (!comments.isEmpty()) {
                    userTaskStatusDto.setReasonComment(comments.get(0).getFullMessage());
                }

            }
        }
        userTaskStatusDtoList = userTaskStatusDtoMap.values();

        return ResponseEntity.ok().body(userTaskStatusDtoList);

    }


}
