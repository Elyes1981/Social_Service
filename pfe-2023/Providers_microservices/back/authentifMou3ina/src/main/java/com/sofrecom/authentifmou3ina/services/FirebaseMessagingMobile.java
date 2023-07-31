package com.sofrecom.authentifmou3ina.services;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.sofrecom.authentifmou3ina.entities.ERole;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.entities.NotificationMessage;
import com.sofrecom.authentifmou3ina.entities.NotificationsHistory;
import com.sofrecom.authentifmou3ina.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FirebaseMessagingMobile {

    private final FirebaseMessaging firebaseMessagingMobile;

    @Autowired
    NotificationRepository notificationRepository ;

    public FirebaseMessagingMobile(@Qualifier("firebaseMessageMobile") FirebaseMessaging firebaseMessagingMobile) {
        this.firebaseMessagingMobile = firebaseMessagingMobile;
    }


    public void sendNotificationToProvider(String title, String body, String token, Mou3inaEntity mou3ina, Long idIntervieww) throws FirebaseMessagingException {

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
        NotificationsHistory notificationHistory = new NotificationsHistory();
        notificationHistory.setTitle(title);
        notificationHistory.setBody(body);
        notificationHistory.setToken(token);
        notificationHistory.setCreatedAt(new Date());
        notificationHistory.setRecipient(ERole.ROLE_USER);
        notificationHistory.setProvider(mou3ina);
        notificationHistory.setIdInterview(idIntervieww);
        notificationRepository.save(notificationHistory);

    }

}
