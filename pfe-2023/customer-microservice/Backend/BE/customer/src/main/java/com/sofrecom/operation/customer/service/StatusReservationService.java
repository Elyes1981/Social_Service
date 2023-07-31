package com.sofrecom.operation.customer.service;

import com.sofrecom.operation.customer.entities.StatusReservation;
import com.sofrecom.operation.customer.dao.StatusReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StatusReservationService implements IStatus {
    @Autowired
    StatusReservationRepository statusReservationRepository;

    @Override
    public StatusReservation addStatus(StatusReservation s) {
     statusReservationRepository.save(s);
        return s;
    }

    @Override
    public void deleteStatus(Long id) {
     if(statusReservationRepository.findById(id).isPresent())
      statusReservationRepository.deleteById(id);
    }

    @Override
    public StatusReservation updateStatus(StatusReservation s) {
        return statusReservationRepository.saveAndFlush(s);
    }

    @Override
    public StatusReservation findStatus(Long code) {
        StatusReservation s = (StatusReservation) statusReservationRepository.findById(code).get();
        return s;
    }

    @Override
    public List<StatusReservation> findAll() {
        return statusReservationRepository.findAll();
    }
}
