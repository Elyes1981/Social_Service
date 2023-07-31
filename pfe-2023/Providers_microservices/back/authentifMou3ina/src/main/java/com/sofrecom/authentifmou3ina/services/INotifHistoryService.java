package com.sofrecom.authentifmou3ina.services;

import com.sofrecom.authentifmou3ina.entities.Gender;
import com.sofrecom.authentifmou3ina.entities.NotificationsHistory;

import java.util.List;

public interface INotifHistoryService {

    public NotificationsHistory addNotificationHistory(NotificationsHistory m);


    public void deleteNotificationHistory(Long id);

    public NotificationsHistory  updateNotificationHistory(NotificationsHistory m);

    public NotificationsHistory  findNotificationHistory (Long id);

    public List<NotificationsHistory> findAll();

}
