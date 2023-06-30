package com.sofrecom.operation.customer.service;

import java.util.List;

import com.sofrecom.operation.customer.entities.StatusReservation;

public interface IStatus {
    public StatusReservation addStatus(StatusReservation s);

    public void deleteStatus(Long id);

    public StatusReservation  updateStatus (StatusReservation s);

    public StatusReservation  findStatus (Long id);

    public List<StatusReservation> findAll();
}
