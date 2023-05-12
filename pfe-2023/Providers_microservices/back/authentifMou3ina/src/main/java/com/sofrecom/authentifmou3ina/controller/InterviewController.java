package com.sofrecom.authentifmou3ina.controller;


import com.sofrecom.authentifmou3ina.entities.Gender;
import com.sofrecom.authentifmou3ina.entities.Interview;
import com.sofrecom.authentifmou3ina.entities.InterviewState;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.repository.InterviewRepository;
import com.sofrecom.authentifmou3ina.repository.Mou3inaRepository;
import com.sofrecom.authentifmou3ina.services.IGender;
import com.sofrecom.authentifmou3ina.services.InterviewService;
import com.sofrecom.authentifmou3ina.services.TrialPeriodService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class InterviewController{

    @Autowired
    InterviewRepository interviewRepository ;

    @Autowired
    Mou3inaRepository mou3inaRepository ;

    @Autowired
    InterviewService interviewService;

    @Autowired
    TrialPeriodService trialPeriodServiceService;

    /*@Autowired
    private JavaMailSender javaMailSender;*/


    @Autowired
    private TaskService taskService;
    @GetMapping (value = "/Interview"/*, method = RequestMethod.GET*/)
    public List<Interview> findInterview() {
        return interviewService.findAll();
    }
    @GetMapping(value = "/Interview/{id}")
    public Interview findInterviewsById(@PathVariable Long id) {
        Interview interview = interviewService.findInterview(id);
        return interview;
    }
    @PostMapping(value = "/Interview/newInterview/{id}")
    public Interview addInterview(@PathVariable Long id,@RequestBody Interview m) {

        /*Mou3inaEntity mouina=(Mou3inaEntity) mou3inaRepository.findById(id).get();
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mouina.getEmailAdress());
        //(mouina.getEmailAdress());
        msg.setSubject("Planification Interview");
        msg.setText("Hello"*//*+mouina.getFirstName()+" "+mouina.getLastName()+ " \n this is your username : \n "+mouina.getUsername().toString()+ "\n and your password :\n"+mouina.getPassword().toString()+"\n you may change them in your first sign in"*//*);
        javaMailSender.send(msg);*/
        return interviewService.addInterview(id,m);
    }




    @PutMapping(value = "/Interviews/Interview/{id}")
    public Interview updateInterview(@PathVariable Long id, @RequestBody Interview p) {
        p.setId(id);
        return interviewService.updateInterview(p);
    }

    @PutMapping(value = "/Interviews/Evaluate/{id}")
    public Interview Evaluate(@PathVariable Long id, @PathVariable InterviewState p) {
        //p.setId(id);
        return interviewService.Evaluate(id,p);
    }

    @DeleteMapping(value = "/deleteInterview/{id}")
    public void deleteInterview(@PathVariable Long id) {
        interviewService.deleteInterview(id);
    }

    @PutMapping(value="/acceptMou3ina/{id}")
    @ResponseBody
    public Interview acceptProvider(@PathVariable Long id){
        Interview inter=interviewService.acceptProvider(id);
        return inter ;
    }

    @PutMapping(value="/rejetMou3ina/{id}")
    @ResponseBody
    public Interview rejectProvider(@PathVariable Long id){
        Interview inter=interviewService.rejectProvider(id);
        return inter ;
    }





}





