package com.sofrecom.authentifmou3ina.Workflow;

import com.sofrecom.authentifmou3ina.repository.Mou3inaRepository;
import com.sofrecom.authentifmou3ina.services.Imou3inaService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class DeleteMou3ina implements JavaDelegate  {

    @Value("${spring.workflow.keydefinitionname}")
    private String keyDefinition ;
    @Autowired
    private Mou3inaRepository mou3inaRepository;

    @Autowired
    Imou3inaService mou3inaService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        /*ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();*/
        RuntimeService runtimeService = delegateExecution.getProcessEngineServices().getRuntimeService();
        runtimeService.deleteProcessInstance(delegateExecution.getProcessInstanceId(),null);
        System.out.println(" running process instance  deleted");
        String instanceId = delegateExecution.getProcessInstanceId();
        //mou3inaRepository.deleteByProcessInstanceID(instanceId);
        mou3inaService.deleteByProcessInstanceID(instanceId);
        System.out.println("prestataire refusé");
        /*Long id = (Long) delegateExecution.getVariable("id");
        mou3inaRepository.deleteById(id);*/

    }
}
