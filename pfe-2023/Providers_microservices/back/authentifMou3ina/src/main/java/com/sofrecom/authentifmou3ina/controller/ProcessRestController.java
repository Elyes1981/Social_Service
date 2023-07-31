package com.sofrecom.authentifmou3ina.controller;

import com.sofrecom.authentifmou3ina.entities.DocState;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.entities.UserTaskStatusDto;
import com.sofrecom.authentifmou3ina.services.Imou3inaService;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;


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
    Imou3inaService mou3inaservice;

    /*@GetMapping("/getListTask")
    public ResponseEntity<Collection<UserTaskStatusDto>> getWorkfloTaskList(@RequestParam(value = "id") Long id){
        Mou3inaEntity user =mou3inaservice.findMou3inaa(id);
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
            //
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
                //

                //userTaskStatusDto.setDecision(true);
                List<Comment> comments = processEngine.getTaskService().getTaskComments(historicTaskInstance.getId());
                if (!comments.isEmpty()) {
                    userTaskStatusDto.setReasonComment(comments.get(0).getFullMessage());
                }

            }
        }
        userTaskStatusDtoList = userTaskStatusDtoMap.values();

        return ResponseEntity.ok().body(userTaskStatusDtoList);

    }*/


    @GetMapping("/getListTask")
    public ResponseEntity<Collection<UserTaskStatusDto>> getWorkfloTaskList(@RequestParam(value = "id") Long id) {
        Mou3inaEntity user = mou3inaservice.findMou3inaa(id);
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        UserTaskStatusDto userTaskStatusDto;
        Collection<UserTaskStatusDto> userTaskStatusDtoList;

        // Id user + task information
        Map<String, UserTaskStatusDto> userTaskStatusDtoMap = new LinkedHashMap<>();

        final List list = repositoryService.createProcessDefinitionQuery().processDefinitionKey(keyDefinition).latestVersion().list();

        final String processDefinitionId = ((ProcessDefinition) list.get(0)).getId();
        LOGGER.info("processDefinitionId: " + processDefinitionId);

        BpmnModelInstance bpmnModelInstance = repositoryService.getBpmnModelInstance(processDefinitionId);
        Collection<UserTask> userTasks = bpmnModelInstance.getModelElementsByType(UserTask.class);

        // Liste des tâches dans l'ordre spécifié
        List<String> taskOrder = Arrays.asList(
                "Planifier entretien",
                "evaluation entretien",
                "Accuser la réception du complément de document administratif",
                "Evaluation de la période de test",
                "renseigner la disponibilité du provider"
        );

        for (UserTask userTask : userTasks) {
            String taskName = userTask.getName();
            if (taskOrder.contains(taskName)) {
                userTaskStatusDto = new UserTaskStatusDto();
                userTaskStatusDto.setUserTaskName(taskName);
                userTaskStatusDto.setProfileName(userTask.getCamundaAssignee());
                userTaskStatusDto.setCandidateUser(userTask.getCamundaCandidateUsers());
                userTaskStatusDtoMap.put(userTask.getId(), userTaskStatusDto);
                if (userTaskStatusDto.getEndTime() != null) {
                    userTaskStatusDto.setDecision(true);
                }
                if (taskName.equals("Accuser la réception du complément de document administratif")) {
                    if (user.getDocState() == DocState.NOT_VERIFIED) {
                        userTaskStatusDto.setDecision(false);
                    }
                }


            }
        }

        HistoricTaskInstanceQuery historicTaskInstanceQuery = processEngine.getHistoryService().createHistoricTaskInstanceQuery();
        List<HistoricTaskInstance> historicTaskInstanceList = historicTaskInstanceQuery
                .processInstanceId(user.getProcessInstanceID())
                .list();
        for (HistoricTaskInstance historicTaskInstance : historicTaskInstanceList) {
            if (userTaskStatusDtoMap.containsKey(historicTaskInstance.getTaskDefinitionKey())) {
                userTaskStatusDto = userTaskStatusDtoMap.get(historicTaskInstance.getTaskDefinitionKey());
                userTaskStatusDto.setStartTime(new DateTime(historicTaskInstance.getStartTime()).toString("dd/MM/yyyy HH:mm:ss"));
                if (historicTaskInstance.getEndTime() != null) {
                    userTaskStatusDto.setEndTime(new DateTime(historicTaskInstance.getEndTime()).toString("dd/MM/yyyy HH:mm:ss"));
                }
                userTaskStatusDto.setDeleteReason(historicTaskInstance.getDeleteReason());
                userTaskStatusDto.setAuthorized(true);


                List<Comment> comments = processEngine.getTaskService().getTaskComments(historicTaskInstance.getId());
                if (!comments.isEmpty()) {
                    userTaskStatusDto.setReasonComment(comments.get(0).getFullMessage());
                }
            }
        }

        userTaskStatusDtoList = userTaskStatusDtoMap.values().stream()
                .sorted(Comparator.comparingInt(task -> taskOrder.indexOf(task.getUserTaskName())))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(userTaskStatusDtoList);
    }

}
