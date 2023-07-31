package com.sofrecom.operation.customer.dao;

import com.sofrecom.operation.customer.entities.Status;
import com.sofrecom.operation.customer.entities.StatusReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StatusRepository extends JpaRepository<Status, Long> {




}
