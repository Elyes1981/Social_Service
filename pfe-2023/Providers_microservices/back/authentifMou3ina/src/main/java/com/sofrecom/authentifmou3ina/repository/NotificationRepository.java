package com.sofrecom.authentifmou3ina.repository;

import com.sofrecom.authentifmou3ina.entities.ERole;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.entities.NotificationsHistory;
import com.sofrecom.authentifmou3ina.entities.TrialPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationsHistory, Long> {

    List<NotificationsHistory> findByRecipient(ERole recipient);

    List<NotificationsHistory> findByRecipientAndProvider(ERole recipient, Mou3inaEntity mouina);

}
