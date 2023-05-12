package com.sofrecom.authentifmou3ina.services;

import com.sofrecom.authentifmou3ina.entities.CleaningServicesCompany;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;

import java.util.List;

public interface ICleaningCompanyService {

    public CleaningServicesCompany addCleaningCompany(CleaningServicesCompany m);

    public void deleteCleaningCompany(Long id);

    public CleaningServicesCompany  updateCleaningCompany (CleaningServicesCompany m);

    public CleaningServicesCompany  findCleaningCompany (Long id);

    public List<CleaningServicesCompany> findAll();

    public  void addMou3inaToCompany(Long id, Mou3inaEntity mou3ina);

    public List<Mou3inaEntity> getMou3inaListByCompanyId(Long companyId) ;
}

