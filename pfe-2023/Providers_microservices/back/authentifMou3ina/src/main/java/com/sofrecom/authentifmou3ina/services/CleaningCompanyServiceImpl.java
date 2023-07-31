package com.sofrecom.authentifmou3ina.services;

import com.sofrecom.authentifmou3ina.entities.CleaningServicesCompany;
import com.sofrecom.authentifmou3ina.entities.DocState;
import com.sofrecom.authentifmou3ina.entities.EmploymentStatus;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.repository.CleaningCompanyRepository;
import com.sofrecom.authentifmou3ina.repository.Mou3inaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CleaningCompanyServiceImpl implements  ICleaningCompanyService{

    @Autowired
    CleaningCompanyRepository cleaningCompanyRepository ;

    @Autowired
    Mou3inaRepository mou3inaRepository ;
    @Override
    public CleaningServicesCompany addCleaningCompany(CleaningServicesCompany m) {
        return  cleaningCompanyRepository.save(m);
    }

    @Override
    public void deleteCleaningCompany(Long id) {
        cleaningCompanyRepository.deleteById(id);


    }

    @Override
    public CleaningServicesCompany updateCleaningCompany(CleaningServicesCompany m) {
        return cleaningCompanyRepository.saveAndFlush(m);
    }

    @Override
    public CleaningServicesCompany findCleaningCompany(Long id) {
        return cleaningCompanyRepository.findById(id).get() ;
    }

    @Override
    public List<CleaningServicesCompany> findAll() {
        return cleaningCompanyRepository.findAll();
    }

    @Override
    public void addMou3inaToCompany(Long id, Mou3inaEntity mou3ina) {
        CleaningServicesCompany company=(CleaningServicesCompany) cleaningCompanyRepository.findById(id).get();
        company.getProviders().add(mou3ina);
        mou3ina.setEmploymentStatus(EmploymentStatus.salaried_employee);
        mou3ina.setDocState(DocState.NO_DOCUMENT_UPLOADED);
        mou3ina.setNbfavoris(0);
        mou3ina.setNbServicesDone(0);
        mou3ina.setN((float) Math.min(Math.max(mou3ina.getN(), 0.02), 0.1));  // sets default value to 2%, and maximum value to 10%
        mou3inaRepository.save(mou3ina);
        cleaningCompanyRepository.save(company);
        System.out.println(("Mou3ina added to company successfully."));
    }

    public Set<Mou3inaEntity> getMou3inaListByCompanyId(Long companyId) {
        Optional<CleaningServicesCompany> optionalCompany = cleaningCompanyRepository.findById(companyId);
            CleaningServicesCompany company = optionalCompany.get();
            Set<Mou3inaEntity> providers = company.getProviders();
            return providers;
    }

    @Override
    public ResponseEntity<Object> getOwnersListByCompanyId(Long id) {
        CleaningServicesCompany company=(CleaningServicesCompany) cleaningCompanyRepository.findById(id).get();
        return new ResponseEntity<>(company.getCompanyOwners(), HttpStatus.OK);
    }
}
