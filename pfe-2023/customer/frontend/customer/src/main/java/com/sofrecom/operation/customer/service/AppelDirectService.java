package com.sofrecom.operation.customer.service;


import com.sofrecom.operation.customer.dao.ConfirmationPresenceRepository;
import com.sofrecom.operation.customer.entities.ConfirmationPresence;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppelDirectService {

    @Value("${spring.workflow.keydefinitionname}")
    private String keyDefinition;

    @Autowired
    private ConfirmationPresenceRepository confirmationPresenceRepository;
    public void save(Long reservationId, String confirmation){
        ConfirmationPresence confirmationPresence= new ConfirmationPresence();
        confirmationPresence.setConfirmationPresence(confirmation);
        confirmationPresence.setReservationId(reservationId);
        validateReport(confirmation);


    }

    public static void validateReport(String confirmation) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey("Process_0423qz2").taskAssignee("Appel").list();
        for(Task task : tasks){

            System.out.println("id: "+task.getId()+ " name: "+ task.getName());
        }
        Task task =tasks.get(0);
        processEngine.getTaskService().setVariable(task.getId(),"isValid",true);
        processEngine.getTaskService().complete(task.getId());
        /* if (tasks != null && !tasks.isEmpty()) {
            Task task = tasks.get(0);
            processEngine.getTaskService().setVariable(task.getId(), "isValid", true);
            processEngine.getTaskService().createComment(task.getId(),commissionReport.getProcessInstanceId(),comment);
            processEngine.getTaskService().complete(task.getId());
        }
        ReportValidationService.updateReportStatus(commissionReport);*/
    }
}
