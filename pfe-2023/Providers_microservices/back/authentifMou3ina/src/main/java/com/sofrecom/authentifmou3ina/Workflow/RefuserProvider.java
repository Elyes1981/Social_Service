package com.sofrecom.authentifmou3ina.Workflow;

import com.sofrecom.authentifmou3ina.config.MyScheduledTask;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.repository.Mou3inaRepository;
import com.sofrecom.authentifmou3ina.repository.NotificationRepository;
import com.sofrecom.authentifmou3ina.services.FirebaseMessagingMobile;
import com.sofrecom.authentifmou3ina.services.FirebaseMessagingService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RefuserProvider implements JavaDelegate {

    private FirebaseMessagingService firebaseService;
    //The "FirebaseMessagingService" class is part of the Firebase Cloud Messaging (FCM) API,
    // which provides a messaging platform for sending notifications and messages to client apps.
    // By injecting an instance of this class into a Spring component,
    // the component can use FCM to send push notifications to mobile devices.

    @Autowired
    Mou3inaRepository mou3inaRepository ;

    @Autowired
    private FirebaseMessagingMobile firebaseServiceMobile;

    @Autowired
    NotificationRepository notificationRepository;

    private MyScheduledTask myScheduledTask;


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {



/*
        firebaseServiceMobile.sendNotificationToProvider("Disapproval ", "Unfortunately , your application has been refused", "eGNkaJYYSmaGPJ-kYdU3Ak:APA91bFAVyacW2BSTJLsnkPCvVXPlJmMNcaV6ukOZhg5a1p5tk9UMYqYjf0mEAapraY3blleqhQFM4jb8iuwaZ5m9nxauTA7OK0YcLK61cYTAZR2pshuWQede68JncD7o2OlB9z3YPrb", mou3ina);

        //il faut recuperer token de l'agent le plus proche du provider
        firebaseService.sendNotificationToAgent("Disapproval ", "the candidate has been refused", "c24_3tH9gfaBeS4VmDDs6B:APA91bF1qeGnOnJBjvkfGqW-4cz6gY8nyvk1WQGqfpBipD_yDoPkmMpdVYEpKOTVsH-fZ4Zdrk6b7NUYRWCZqJyoHsyD_Woe4xI49m-9uSsv2GLLmc6PdHYaWau6gk3Qv0zOiEMZg3su", mou3ina);
*/

        System.out.println("notification envoyée");

    }

}
