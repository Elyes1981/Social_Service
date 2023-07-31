package com.sofrecom.operation.admin.dao;

import com.sofrecom.operation.admin.entities.StatusReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusReservationRepository extends JpaRepository<StatusReservation, Long> {
    Optional<StatusReservation> findById(Long Id);
}
