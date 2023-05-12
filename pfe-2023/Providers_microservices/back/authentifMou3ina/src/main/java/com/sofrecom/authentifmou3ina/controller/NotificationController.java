package com.sofrecom.authentifmou3ina.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.sofrecom.authentifmou3ina.entities.Gender;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.entities.NotificationHistory;
import com.sofrecom.authentifmou3ina.entities.NotificationMessage;
import com.sofrecom.authentifmou3ina.services.FirebaseMessagingService;
import com.sofrecom.authentifmou3ina.services.INotifHistoryService;
import com.sofrecom.authentifmou3ina.services.NotifHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/notification")
public class NotificationController {
    /*@Autowired
    FirebaseMessagingService firebaseMessagingService;*/

    @Autowired
    private FirebaseMessagingService firebaseService;

    @Autowired
    private INotifHistoryService notifHistoryService;


    @GetMapping(value = "/Agent/Notification")
    public String sendTargetedNotification() throws FirebaseMessagingException {
        firebaseService.sendNotificationToAgent("notification de rappel ", "Notification Text", "c24_3tH9gfaBeS4VmDDs6B:APA91bF1qeGnOnJBjvkfGqW-4cz6gY8nyvk1WQGqfpBipD_yDoPkmMpdVYEpKOTVsH-fZ4Zdrk6b7NUYRWCZqJyoHsyD_Woe4xI49m-9uSsv2GLLmc6PdHYaWau6gk3Qv0zOiEMZg3su");
        return "notif" ;
    }

    @GetMapping(value = "/Agent/NotificationHistory")
    public List<NotificationHistory> findNotificationHistory() {
        return notifHistoryService.findAll();
    }
}
