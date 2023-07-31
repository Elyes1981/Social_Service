package com.sofrecom.operation.customer.dao;

import com.sofrecom.operation.customer.entities.StatusReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusReservationRepository extends JpaRepository<StatusReservation, Long> {
    Optional<StatusReservation> findById(Long Id);

   // StatusReservation findByStatus_en(String statusEn);

}
