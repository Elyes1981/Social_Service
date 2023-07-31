package com.sofrecom.authentifmou3ina.services;

import com.sofrecom.authentifmou3ina.entities.CleaningServicesCompany;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface ICleaningCompanyService {

    public CleaningServicesCompany addCleaningCompany(CleaningServicesCompany m);

    public void deleteCleaningCompany(Long id);

    public CleaningServicesCompany  updateCleaningCompany (CleaningServicesCompany m);

    public CleaningServicesCompany  findCleaningCompany (Long id);

    public List<CleaningServicesCompany> findAll();

    public  void addMou3inaToCompany(Long id, Mou3inaEntity mou3ina);

    public Set<Mou3inaEntity> getMou3inaListByCompanyId(Long companyId) ;

    public ResponseEntity<Object> getOwnersListByCompanyId(Long companyId) ;


    //List<Mou3inaEntity> getProvidersByCompanyId(Long companyId);

}

