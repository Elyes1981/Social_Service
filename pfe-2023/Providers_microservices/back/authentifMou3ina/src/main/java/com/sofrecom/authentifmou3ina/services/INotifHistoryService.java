package com.sofrecom.authentifmou3ina.services;

import com.sofrecom.authentifmou3ina.entities.Gender;
import com.sofrecom.authentifmou3ina.entities.NotificationHistory;

import java.util.List;

public interface INotifHistoryService {

    public NotificationHistory addNotificationHistory(NotificationHistory m);


    public void deleteNotificationHistory(Long id);

    public NotificationHistory  updateNotificationHistory(NotificationHistory m);

    public NotificationHistory  findNotificationHistory (Long id);

    public List<NotificationHistory> findAll();

}
