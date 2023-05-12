package com.sofrecom.authentifmou3ina.services;

import com.sofrecom.authentifmou3ina.entities.Interview;
import com.sofrecom.authentifmou3ina.entities.InterviewState;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.entities.TrialPeriod;
import com.sofrecom.authentifmou3ina.repository.InterviewRepository;
import com.sofrecom.authentifmou3ina.repository.Mou3inaRepository;
import com.sofrecom.authentifmou3ina.repository.TrialPeriodRepository;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewImpl implements InterviewService{

    @Autowired
    InterviewRepository interviewRepository ;

    @Autowired
    Mou3inaRepository mou3inaRepository ;

    @Autowired
    TrialPeriodRepository trialPeriodRepository ;



    @Value("${spring.workflow.keydefinitionname}")
    private String keyDefinition ;

    @Autowired
    private TaskService taskService;


    @Override
    public Interview addInterview(Long id,Interview m) {
        Mou3inaEntity mouina=(Mou3inaEntity) mou3inaRepository.findById(id).get();
        m.setMou3inaInterview(mouina);
        m.setState(InterviewState.WAITING);
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        //List<Task> tasks = taskService.createTaskQuery().processInstanceId(mouina.getProcessInstanceID()).list();
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(keyDefinition).taskAssignee("demo").list();
        System.out.println(tasks);
        //if (tasks != null && !tasks.isEmpty()) {
        Task task = tasks.get(0);
        //System.out.println(task);
        processEngine.getTaskService().setVariable(task.getId(), "isValid", true);
        processEngine.getTaskService().complete(task.getId());
        System.out.println(tasks);

        //}
        //else {
            //System.out.println("Error completing user task: ");
       // }
        return interviewRepository.save(m);

    }

    @Override
    public void deleteInterview(Long id) {
        interviewRepository.deleteById(id);

    }

    @Override
    public Interview updateInterview(Interview m) {
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
        //m.setMou3inaInterview(m.getMou3inaInterview());
        Long id = Long.valueOf(104);
        TrialPeriod trialPeriod = new TrialPeriod();
        Mou3inaEntity mou3ina =mou3inaRepository.findById(id).get();
        //Mou3inaEntity mou3ina = m.getMou3inaInterview();
        if(m.getState()==InterviewState.ACCEPTED){
            trialPeriod.setMou3inaInterview(mou3ina);
            trialPeriod.setState(InterviewState.WAITING);
            trialPeriodRepository.save(trialPeriod);

        }
        m.setMou3inaInterview(mou3ina);
        return interviewRepository.saveAndFlush(m);
    }

    @Override
    public Interview findInterview(Long id) {
        return interviewRepository.findById(id).get() ;
    }

    @Override
    public List<Interview> findAll() {
        return interviewRepository.findAll();    }

    @Override
    public Interview acceptProvider(Long id) {
       /* ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(keyDefinition).taskAssignee("demo").list();
        System.out.println(tasks);
        //if (tasks != null && !tasks.isEmpty()) {
        Task task = tasks.get(0);
        //System.out.println(task);
        //processEngine.getTaskService().setVariable("state" ,"accepted" ,true);
        processEngine.getTaskService().setVariable(task.getId(), "isValid", true);
        processEngine.getTaskService().complete(task.getId());*/
        Long idmou3ina = Long.valueOf(71);
        Mou3inaEntity mou3ina =mou3inaRepository.findById(idmou3ina).get();
        Interview inter = interviewRepository.findById(id).get();
        TrialPeriod trial = trialPeriodRepository.findByMou3inaInterview(mou3ina);
        trial.setState(InterviewState.ACCEPTED);
        //inter.setState(InterviewState.ACCEPTED);
        trialPeriodRepository.save(trial);
        return inter;
    }

    @Override
    public Interview Evaluate (Long id , InterviewState state){
        Interview inter = interviewRepository.findById(id).get();
        //Mou3inaEntity mou3ina = inter.getMou3inaInterview();
        inter.setState(state);
        interviewRepository.save(inter);
        return inter;
    }


    @Override
    public Interview rejectProvider(Long id) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(keyDefinition).taskAssignee("demo").list();
        System.out.println(tasks);
        //if (tasks != null && !tasks.isEmpty()) {
        Task task = tasks.get(0);
        //System.out.println(task);
        //processEngine.getTaskService().setVariable("state" ,"accepted" ,true);
        processEngine.getTaskService().setVariable(task.getId(), "isValid", false);
        processEngine.getTaskService().complete(task.getId());
        Interview inter = interviewRepository.findById(id).get();
        inter.setState(InterviewState.REJECTED);
        interviewRepository.save(inter);
        return inter;
    }
}
