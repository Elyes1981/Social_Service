package com.sofrecom.authentifmou3ina.services;
import com.google.firebase.messaging.*;
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
public class FirebaseMessagingService {

    private final FirebaseMessaging firebaseMessagingWeb;

    @Autowired
    NotificationRepository notificationRepository ;

    public FirebaseMessagingService(@Qualifier("firebaseMessageWeb") FirebaseMessaging firebaseMessagingWeb) {
        this.firebaseMessagingWeb = firebaseMessagingWeb;
    }


    public void sendNotificationToAgent(String title, String body, String token , Mou3inaEntity provider, Long idIntervieww) throws FirebaseMessagingException {

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
        firebaseMessagingWeb.send(message);
        NotificationsHistory notificationHistory = new NotificationsHistory();
        notificationHistory.setTitle(title);
        notificationHistory.setBody(body);
        notificationHistory.setToken(token);
        notificationHistory.setCreatedAt(new Date());
        notificationHistory.setRecipient(ERole.ROLE_ADMIN);
        notificationHistory.setProvider(provider);
        notificationHistory.setIdInterview(idIntervieww);
        notificationRepository.save(notificationHistory);




// For Send to multiple devices use Multicast Message Builder

        /*MulticastMessage message = MulticastMessage
                .builder()
                .addAllTokens(<List Of Tokens>)
                .setNotification(notification)
//              .putAllData(note.getData())
                .build();
        firebaseMessaging.send(message);*/
    }

    public String sendNotifiationByToken(NotificationMessage notificationMessage){
        Notification notification = Notification
                .builder()
                .setTitle(notificationMessage.getTitle())
                .setBody(notificationMessage.getBody())
                .setImage(notificationMessage.getImage())
                .build();
        Message message =Message.builder().
                setToken(notificationMessage.getRecipientToken())
                .setNotification(notification)
                .putAllData(notificationMessage.getData())
                .build();

        try {
            firebaseMessagingWeb.send(message);
            return "Suesss sending Notification" ;
        }catch (FirebaseMessagingException e){
            e.printStackTrace();
            return "error sending notification";

        }
    }
}
