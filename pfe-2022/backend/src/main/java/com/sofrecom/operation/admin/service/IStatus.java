package com.sofrecom.operation.admin.service;

import java.util.List;

import com.sofrecom.operation.admin.entities.StatusReservation;

public interface IStatus {
    public StatusReservation addStatus(StatusReservation s);

    public void deleteStatus(Long id);

    public StatusReservation  updateStatus (StatusReservation s);

    public StatusReservation  findStatus (Long id);

    public List<StatusReservation> findAll();
}
