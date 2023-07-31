package com.sofrecom.authentifmou3ina.Workflow;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.sofrecom.authentifmou3ina.config.MyScheduledTask;
import com.sofrecom.authentifmou3ina.entities.Gender;
import com.sofrecom.authentifmou3ina.entities.Interview;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.repository.Mou3inaRepository;
import com.sofrecom.authentifmou3ina.repository.NotificationRepository;
import com.sofrecom.authentifmou3ina.services.EmailSenderService;
import com.sofrecom.authentifmou3ina.services.FirebaseMessagingMobile;
import com.sofrecom.authentifmou3ina.services.FirebaseMessagingService;
import com.sofrecom.authentifmou3ina.services.InterviewImpl;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
@Component
public class TestCamunda  implements JavaDelegate {



    @Autowired
    Mou3inaRepository mou3inaRepository ;

    @Value("${spring.workflow.keydefinitionname}")
    private String keyDefinition ;

    @Autowired
    private FirebaseMessagingService firebaseService;
    //The "FirebaseMessagingService" class is part of the Firebase Cloud Messaging (FCM) API,
    // which provides a messaging platform for sending notifications and messages to client apps.
    // By injecting an instance of this class into a Spring component,
    // the component can use FCM to send push notifications to mobile devices.

    @Autowired
    private FirebaseMessagingMobile firebaseServiceMobile;

    @Autowired
    NotificationRepository notificationRepository ;

    private MyScheduledTask myScheduledTask;

    //@Autowired
    //EmailSenderService emailsenderservice ;
    private static final String WEB_SERVICE_URL = "http://localhost:8088/Mou3ina/newMou3ina";

    //private final Logger LOGGER = LoggerFactory.getLogger(Gender.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        /*String instanceId = delegateExecution.getProcessInstanceId();

        Mou3inaEntity mou3ina = mou3inaRepository.findByProcessInstanceID(instanceId);


        //Mou3inaEntity mou3ina = mou3inaRepository.findById(97L).get();


        firebaseServiceMobile.sendNotificationToProvider("Rappel ", "Notification Text", "eGNkaJYYSmaGPJ-kYdU3Ak:APA91bFAVyacW2BSTJLsnkPCvVXPlJmMNcaV6ukOZhg5a1p5tk9UMYqYjf0mEAapraY3blleqhQFM4jb8iuwaZ5m9nxauTA7OK0YcLK61cYTAZR2pshuWQede68JncD7o2OlB9z3YPrb", mou3ina);

        //il faut recuperer token de l'agent le plus proche du provider
        firebaseService.sendNotificationToAgent("Rappel ", "Notification Text", "c24_3tH9gfaBeS4VmDDs6B:APA91bF1qeGnOnJBjvkfGqW-4cz6gY8nyvk1WQGqfpBipD_yDoPkmMpdVYEpKOTVsH-fZ4Zdrk6b7NUYRWCZqJyoHsyD_Woe4xI49m-9uSsv2GLLmc6PdHYaWau6gk3Qv0zOiEMZg3su" , mou3ina);*/

        System.out.println("notification envoyée");

        



       /*RestTemplate restTemplate = new RestTemplate();

        // Appeler le service GET et récupérer la réponse dans une variable
        String url = "http://localhost:8088/Gender";
        List<Gender> genders = restTemplate.getForObject(url, List.class);

        // Mettre à jour une variable de processus avec la réponse
        delegateExecution.setVariable("genders", genders);*/

        /*Mou3inaEntity mou3ina = (Mou3inaEntity) delegateExecution.getVariable("mou3ina");

        // Configuration des en-têtes HTTP pour la requête POST
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Création de l'objet HttpEntity avec l'objet Mou3inaEntity en corps de la requête
        HttpEntity<Mou3inaEntity> request = new HttpEntity<>(mou3ina, headers);

        // Appel du service web avec RestTemplate et récupération de la réponse
        RestTemplate restTemplate = new RestTemplate();
        Mou3inaEntity response = restTemplate.postForObject(WEB_SERVICE_URL, request, Mou3inaEntity.class);

        // Enregistrement de la réponse dans les variables de processus de Camunda
        delegateExecution.setVariable("response", response);*/

/*        int year = 2023;
        int month = 6;
        int day = 1;
        LocalDate variableDate = LocalDate.of(year, month, day);

        Runnable method = () -> {
            try {
                firebaseService.sendNotificationToAgent("notification de rappel ", "Notification Text", "dT73y0unS66oBqxCzNZFk4:APA91bHkrxvNbFvD3mG-Ll72zIapeULkLwlse1bGF2ASZ-j8X3csuB5fH3UFFRmpoaGBRW9BVWqMeLbpTQat1hTVES6q5Au4yJw9g26VlCqyTM7TSu4fqtFnB6mguVMz4RZkc355dROh");
            } catch (FirebaseMessagingException e) {
                throw new RuntimeException(e);
            }
        };
        myScheduledTask.scheduleMethodAtDate(variableDate, method);
        System.out.println("notification envoyée");*/

    }
}
