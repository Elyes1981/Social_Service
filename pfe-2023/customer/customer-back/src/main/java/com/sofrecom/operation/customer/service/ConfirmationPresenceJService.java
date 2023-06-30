package com.sofrecom.operation.customer.service;


import com.sofrecom.operation.customer.dao.ConfirmationPresenceJRepository;
import com.sofrecom.operation.customer.entities.ConfirmationPresenceJ;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfirmationPresenceJService {

    @Value("${spring.workflow.keydefinitionname}")
    private String keyDefinition;

    @Autowired
    private ConfirmationPresenceJRepository confirmationPresenceJRepository;
    public void save(Long reservationId, String confirmationJ){
        ConfirmationPresenceJ confirmationPresenceJ= new ConfirmationPresenceJ();
        confirmationPresenceJ.setConfirmationPresenceJ(confirmationJ);
        confirmationPresenceJ.setReservationId(reservationId);
        validateReport(confirmationJ);


    }

    public static void validateReport(String confirmationJ) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey("Process_1exax7n").taskAssignee("Provaider2").list();
        for(Task task : tasks){

            System.out.println("id: "+task.getId()+ " name: "+ task.getName());
        }
        Task task =tasks.get(0);
        processEngine.getTaskService().setVariable(task.getId(),"isValid",confirmationJ.equals("OK"));
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
