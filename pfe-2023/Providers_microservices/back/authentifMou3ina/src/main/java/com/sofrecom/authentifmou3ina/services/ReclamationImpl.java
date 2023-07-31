package com.sofrecom.authentifmou3ina.services;

import com.sofrecom.authentifmou3ina.entities.Reclamation;
import com.sofrecom.authentifmou3ina.repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamationImpl implements IReclamationService {


    @Autowired
    ReclamationRepository reclamationRepository;

    @Override
    public Reclamation addRerclamation(Reclamation m) {
        return  reclamationRepository.save(m);
    }

    @Override
    public void deleteRerclamation(Long id) {
        if(reclamationRepository.findById(id).isPresent())
            reclamationRepository.deleteById(id);

    }

    @Override
    public Reclamation updateRerclamation(Reclamation m) {
        return reclamationRepository.saveAndFlush(m);
    }

    @Override
    public Reclamation findRerclamation(Long id) {
        Reclamation m=(Reclamation) reclamationRepository.findById(id).get();

        return m;
    }

    @Override
    public List<Reclamation> findAll() {
        return reclamationRepository.findAll();
    }}
