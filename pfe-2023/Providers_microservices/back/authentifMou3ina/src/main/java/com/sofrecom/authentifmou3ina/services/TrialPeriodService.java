package com.sofrecom.authentifmou3ina.services;

import com.sofrecom.authentifmou3ina.entities.InterviewState;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.entities.TrialPeriod;
import com.sofrecom.authentifmou3ina.repository.Mou3inaRepository;
import com.sofrecom.authentifmou3ina.repository.TrialPeriodRepository;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrialPeriodService implements ITrialPeriodService {

    @Autowired
    Mou3inaRepository mou3inaRepository ;

    @Autowired
    TrialPeriodRepository trialPeriodRepository ;



    @Value("${spring.workflow.keydefinitionname}")
    private String keyDefinition ;

    @Autowired
    private TaskService taskService;
    @Override
    public TrialPeriod addTrialPeriod(Long id ,TrialPeriod m) {
        Mou3inaEntity mouina=(Mou3inaEntity) mou3inaRepository.findById(id).get();
        m.setMou3inaInterview(mouina);
        m.setState(InterviewState.WAITING);
        return trialPeriodRepository.save(m);
    }

    @Override
    public void deleteTrialPeriod(Long id) {
        if(trialPeriodRepository.findById(id).isPresent())
            trialPeriodRepository.deleteById(id);
    }

    @Override
    public TrialPeriod updateTrialPeriod(TrialPeriod m) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(keyDefinition).taskAssignee("demo").list();
        System.out.println(tasks);
        //if (tasks != null && !tasks.isEmpty()) {
        Task task = tasks.get(0);
        //System.out.println(task);
        //processEngine.getTaskService().setVariable("state" ,"accepted" ,true);
        processEngine.getTaskService().setVariable(task.getId(), "isValid", true);
        processEngine.getTaskService().complete(task.getId());

        return trialPeriodRepository.saveAndFlush(m);
    }

    @Override
    public TrialPeriod findTrialPeriod(Long id) {
        TrialPeriod m=(TrialPeriod) trialPeriodRepository.findById(id).get();
        return m;
    }

    @Override
    public TrialPeriod findByMou3inaInterviewId(Long id) {
        return null;
    }
}
