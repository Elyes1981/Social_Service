package com.sofrecom.authentifmou3ina.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.sofrecom.authentifmou3ina.entities.ERole;
import com.sofrecom.authentifmou3ina.entities.Gender;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.entities.NotificationsHistory;
import com.sofrecom.authentifmou3ina.repository.Mou3inaRepository;
import com.sofrecom.authentifmou3ina.repository.NotificationRepository;
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

    @Autowired
    Mou3inaRepository mou3inaRepository ;

    @Autowired
    private NotificationRepository notificationRepository;


    //		Mou3inaEntity mouina=(Mou3inaEntity) mou3inaRepository.findById(id).get();
  /*  @GetMapping(value = "/Provider/Notifications")
    public List<NotificationsHistory> getProviderNotifications() {
        return notificationRepository.findByRecipient(ERole.ROLE_USER);
    }*/


    @GetMapping(value = "/Provider/Notifications/{id}")
    public List<NotificationsHistory> getProviderNotifications(@PathVariable Long id) {
        Mou3inaEntity mouina=(Mou3inaEntity) mou3inaRepository.findById(id).get();
        return notificationRepository.findByRecipientAndProvider(ERole.ROLE_USER, mouina);
    }

    @GetMapping(value = "/Agent/Notifications")
    public List<NotificationsHistory> getAgentNotifications() {
        return notificationRepository.findByRecipient(ERole.ROLE_ADMIN);
    }



  /*  @GetMapping(value = "/Agent/Notification")
    public String sendTargetedNotification() throws FirebaseMessagingException {

        Mou3inaEntity mou3ina = mou3inaRepository.findById(97L).get();
        firebaseService.sendNotificationToAgent("notification de rappel ", "Notification Text", "c24_3tH9gfaBeS4VmDDs6B:APA91bF1qeGnOnJBjvkfGqW-4cz6gY8nyvk1WQGqfpBipD_yDoPkmMpdVYEpKOTVsH-fZ4Zdrk6b7NUYRWCZqJyoHsyD_Woe4xI49m-9uSsv2GLLmc6PdHYaWau6gk3Qv0zOiEMZg3su" , mou3ina);
        return "notif" ;
    }*/



    /*@GetMapping(value = "/Agent/NotificationHistory")
    public List<NotificationHistory> findNotificationHistory() {
        return notifHistoryService.findAll();
    }*/
}
