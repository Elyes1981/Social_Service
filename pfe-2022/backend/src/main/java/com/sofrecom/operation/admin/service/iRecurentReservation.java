package com.sofrecom.operation.admin.service;


import com.sofrecom.operation.admin.entities.Recurrentreservation;

import java.util.List;

public interface iRecurentReservation {

    public Recurrentreservation addRecurrent(Recurrentreservation r);


    public void deleteRecurrent(long id);

    public Recurrentreservation  updateRecurrent (Recurrentreservation r);

    public Recurrentreservation  findRecurrent (long id);

    public List<Recurrentreservation> findAll() ;
}
