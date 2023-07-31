package com.sofrecom.authentifmou3ina.services;

import com.google.firebase.messaging.FirebaseMessagingException;
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
import org.camunda.bpm.engine.history.HistoricTaskInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterviewImpl implements InterviewService{

    @Autowired
    InterviewRepository interviewRepository ;

    @Autowired
    Mou3inaRepository mou3inaRepository ;

    @Autowired
    TrialPeriodRepository trialPeriodRepository ;

    @Autowired
    private FirebaseMessagingService firebaseService;
    //The "FirebaseMessagingService" class is part of the Firebase Cloud Messaging (FCM) API,
    // which provides a messaging platform for sending notifications and messages to client apps.
    // By injecting an instance of this class into a Spring component,
    // the component can use FCM to send push notifications to mobile devices.

    @Autowired
    private FirebaseMessagingMobile firebaseServiceMobile;



    @Value("${spring.workflow.keydefinitionname}")
    private String keyDefinition ;

    @Autowired
    private TaskService taskService;


    @Override
    public Interview addInterview(Long id,Interview m) throws FirebaseMessagingException {
        Mou3inaEntity mouina=(Mou3inaEntity) mou3inaRepository.findById(id).get();
        m.setMou3inaInterview(mouina);
        m.setState(InterviewState.WAITING);
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        //List<Task> tasks = taskService.createTaskQuery().processInstanceId(mouina.getProcessInstanceID()).list();
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(keyDefinition).taskAssignee("demo").processInstanceId(mouina.getProcessInstanceID()).list();
        System.out.println(tasks);
        //if (tasks != null && !tasks.isEmpty()) {
        Task task = tasks.get(0);
        //System.out.println(task);
        processEngine.getTaskService().setVariable(task.getId(), "isValid", true);
        processEngine.getTaskService().complete(task.getId());
        System.out.println(tasks);
        firebaseServiceMobile.sendNotificationToProvider("Rappel", "You have an interview scheduled for "+m.getDateInterview(), "eGNkaJYYSmaGPJ-kYdU3Ak:APA91bFAVyacW2BSTJLsnkPCvVXPlJmMNcaV6ukOZhg5a1p5tk9UMYqYjf0mEAapraY3blleqhQFM4jb8iuwaZ5m9nxauTA7OK0YcLK61cYTAZR2pshuWQede68JncD7o2OlB9z3YPrb", mouina, m.getId());

        //il faut recuperer token de l'agent le plus proche du provider
        firebaseService.sendNotificationToAgent("Rappel", "You have an interview scheduled for "+m.getDateInterview()+" with "+mouina.getFirstName()+" "+mouina.getLastName(), "c24_3tH9gfaBeS4VmDDs6B:APA91bF1qeGnOnJBjvkfGqW-4cz6gY8nyvk1WQGqfpBipD_yDoPkmMpdVYEpKOTVsH-fZ4Zdrk6b7NUYRWCZqJyoHsyD_Woe4xI49m-9uSsv2GLLmc6PdHYaWau6gk3Qv0zOiEMZg3su" , mouina , m.getId());


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
    public Interview updateInterview(Interview m) throws FirebaseMessagingException {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        Mou3inaEntity mouina = m.getMou3inaInterview();
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(keyDefinition).taskAssignee("demo").processInstanceId(mouina.getProcessInstanceID()).list();
        System.out.println(m.getMou3inaInterview().getProcessInstanceID());
        System.out.println(tasks);
        //if (tasks != null && !tasks.isEmpty()) {
       /* Task task = tasks.get(0);*/

        Task evaluationEntretienTask = null;
        for (Task task : tasks) {
            if ("evaluation entretien".equals(task.getName())) {
                evaluationEntretienTask = task;
                break;
            }
        }


            TrialPeriod trialPeriod = new TrialPeriod();
            Mou3inaEntity mou3ina = m.getMou3inaInterview();
            System.out.println(mou3ina.getId());
            if(m.getState()==InterviewState.ACCEPTED){
                processEngine.getTaskService().setVariable(evaluationEntretienTask.getId(), "isValid", true);
                processEngine.getTaskService().complete(evaluationEntretienTask.getId());
                trialPeriod.setMou3inaInterview(mou3ina);
                trialPeriod.setState(InterviewState.WAITING);
                trialPeriodRepository.save(trialPeriod);
                Mou3inaEntity provider=(Mou3inaEntity) mou3inaRepository.findById(m.getMou3inaInterview().getId()).get();

                firebaseServiceMobile.sendNotificationToProvider("Approval", "Congratulations "+provider.getFirstName()+" ! your application has been accepted !", "eGNkaJYYSmaGPJ-kYdU3Ak:APA91bFAVyacW2BSTJLsnkPCvVXPlJmMNcaV6ukOZhg5a1p5tk9UMYqYjf0mEAapraY3blleqhQFM4jb8iuwaZ5m9nxauTA7OK0YcLK61cYTAZR2pshuWQede68JncD7o2OlB9z3YPrb" , mou3ina , m.getId());

                //il faut recuperer token de l'agent le plus proche du provider
                firebaseService.sendNotificationToAgent("Approval", "The candidate "+provider.getFirstName()+' '+provider.getLastName()+ " has been accepted to join our team ", "c24_3tH9gfaBeS4VmDDs6B:APA91bF1qeGnOnJBjvkfGqW-4cz6gY8nyvk1WQGqfpBipD_yDoPkmMpdVYEpKOTVsH-fZ4Zdrk6b7NUYRWCZqJyoHsyD_Woe4xI49m-9uSsv2GLLmc6PdHYaWau6gk3Qv0zOiEMZg3su" , mou3ina, m.getId());

                System.out.println("notification envoyée");

            }
            if(m.getState()==InterviewState.REJECTED){
                processEngine.getTaskService().setVariable(evaluationEntretienTask.getId(), "isValid", false);
                processEngine.getTaskService().complete(evaluationEntretienTask.getId());
                Mou3inaEntity provider=(Mou3inaEntity) mou3inaRepository.findById(m.getMou3inaInterview().getId()).get();

                firebaseServiceMobile.sendNotificationToProvider("Disapproval", "Unfortunately , your application has been refused", "eGNkaJYYSmaGPJ-kYdU3Ak:APA91bFAVyacW2BSTJLsnkPCvVXPlJmMNcaV6ukOZhg5a1p5tk9UMYqYjf0mEAapraY3blleqhQFM4jb8iuwaZ5m9nxauTA7OK0YcLK61cYTAZR2pshuWQede68JncD7o2OlB9z3YPrb", mou3ina  , m.getId());

                //il faut recuperer token de l'agent le plus proche du provider
                firebaseService.sendNotificationToAgent("Disapproval", "The candidate "+provider.getFirstName()+' '+provider.getLastName()+" has been refused", "c24_3tH9gfaBeS4VmDDs6B:APA91bF1qeGnOnJBjvkfGqW-4cz6gY8nyvk1WQGqfpBipD_yDoPkmMpdVYEpKOTVsH-fZ4Zdrk6b7NUYRWCZqJyoHsyD_Woe4xI49m-9uSsv2GLLmc6PdHYaWau6gk3Qv0zOiEMZg3su", mou3ina, m.getId());
                System.out.println("notification envoyée");
            }



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
