package com.sofrecom.authentifmou3ina.repository;

import com.sofrecom.authentifmou3ina.entities.NotificationHistory;
import com.sofrecom.authentifmou3ina.entities.TrialPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationHistory, Long> {
}
