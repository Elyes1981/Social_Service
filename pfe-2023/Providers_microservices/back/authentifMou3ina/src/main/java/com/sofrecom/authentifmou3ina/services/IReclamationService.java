package com.sofrecom.authentifmou3ina.services;

import com.sofrecom.authentifmou3ina.entities.Reclamation;

import java.util.List;

public interface IReclamationService {
    public Reclamation addRerclamation(Reclamation m);

    public void deleteRerclamation(Long id);

    public Reclamation  updateRerclamation (Reclamation m);

    public Reclamation  findRerclamation (Long id);







    public List<Reclamation> findAll();

}

