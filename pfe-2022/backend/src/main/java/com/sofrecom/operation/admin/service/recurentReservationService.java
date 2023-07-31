package com.sofrecom.operation.admin.service;
import com.sofrecom.operation.admin.dao.RecurentReservationRepository;
import com.sofrecom.operation.admin.entities.Recurrentreservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class recurentReservationService implements  iRecurentReservation{

    @Autowired
    RecurentReservationRepository recurentRepository;

    @Override
    public Recurrentreservation addRecurrent(Recurrentreservation r) {

        return recurentRepository.save(r);
    }

    @Override
    public void deleteRecurrent(long id) {
        if(recurentRepository.findById(id).isPresent())
            recurentRepository.deleteById(id);
    }

    @Override
    public Recurrentreservation updateRecurrent(Recurrentreservation r) {

        return recurentRepository.saveAndFlush(r);
    }

    @Override
    public Recurrentreservation findRecurrent(long id) {
        Recurrentreservation m=(Recurrentreservation) recurentRepository.findById(id).get();
        return m;}
    @Override
    public List<Recurrentreservation> findAll() {

        return recurentRepository.findAll();
    }



}
