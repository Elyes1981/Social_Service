package com.sofrecom.authentifmou3ina.services;

import com.sofrecom.authentifmou3ina.entities.Gender;
import com.sofrecom.authentifmou3ina.entities.NotificationHistory;
import com.sofrecom.authentifmou3ina.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotifHistoryServiceImpl implements INotifHistoryService{

    @Autowired
    NotificationRepository notificationRepository;

    @Override
    public NotificationHistory addNotificationHistory(NotificationHistory m) {
        return notificationRepository.save(m);
    }

    @Override
    public void deleteNotificationHistory(Long id) {
        if(notificationRepository.findById(id).isPresent())
            notificationRepository.deleteById(id);

    }

    @Override
    public NotificationHistory updateNotificationHistory(NotificationHistory m) {
        return notificationRepository.saveAndFlush(m);
    }

    @Override
    public NotificationHistory findNotificationHistory(Long id) {
        NotificationHistory m=(NotificationHistory) notificationRepository.findById(id).get();
        return m;
    }

    @Override
    public List<NotificationHistory> findAll() {
        return notificationRepository.findAll();
    }
}
