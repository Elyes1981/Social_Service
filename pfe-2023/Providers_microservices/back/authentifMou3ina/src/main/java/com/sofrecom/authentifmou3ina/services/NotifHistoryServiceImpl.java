package com.sofrecom.authentifmou3ina.services;

import com.sofrecom.authentifmou3ina.entities.Gender;
import com.sofrecom.authentifmou3ina.entities.NotificationsHistory;
import com.sofrecom.authentifmou3ina.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotifHistoryServiceImpl implements INotifHistoryService{

    @Autowired
    NotificationRepository notificationRepository;

    @Override
    public NotificationsHistory addNotificationHistory(NotificationsHistory m) {
        return notificationRepository.save(m);
    }

    @Override
    public void deleteNotificationHistory(Long id) {
        if(notificationRepository.findById(id).isPresent())
            notificationRepository.deleteById(id);

    }

    @Override
    public NotificationsHistory updateNotificationHistory(NotificationsHistory m) {
        return notificationRepository.saveAndFlush(m);
    }

    @Override
    public NotificationsHistory findNotificationHistory(Long id) {
        NotificationsHistory m=(NotificationsHistory) notificationRepository.findById(id).get();
        return m;
    }

    @Override
    public List<NotificationsHistory> findAll() {
        return notificationRepository.findAll();
    }
}
