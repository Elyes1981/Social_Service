package com.sofrecom.authentifmou3ina.services;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.sofrecom.authentifmou3ina.entities.NotificationMessage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FirebaseMessagingMobile {

    private final FirebaseMessaging firebaseMessagingMobile;

    public FirebaseMessagingMobile(@Qualifier("firebaseMessageMobile") FirebaseMessaging firebaseMessagingMobile) {
        this.firebaseMessagingMobile = firebaseMessagingMobile;
    }


    public void sendNotificationToProvider(String title, String body, String token) throws FirebaseMessagingException {

        Notification notification = Notification
                .builder()
                .setTitle(title)
                .setBody(body)
                .build();

        Message message = Message
                .builder()
                .setToken(token)
                .setNotification(notification)
                //.putAllData(note.getData())
                .build();
        firebaseMessagingMobile.send(message);

    }

}
