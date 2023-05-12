package com.sofrecom.authentifmou3ina.services;

import com.sofrecom.authentifmou3ina.entities.CleaningServicesCompany;
import com.sofrecom.authentifmou3ina.entities.EmploymentStatus;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.repository.CleaningCompanyRepository;
import com.sofrecom.authentifmou3ina.repository.Mou3inaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

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
        System.out.println(id);
        company.getProviders().add(mou3ina);
        //mou3ina.setEmploymentStatus(EmploymentStatus.salaried_employee);
        mou3ina.setFixedPart(300);
        mou3ina.setNbfavoris(0);
        mou3ina.setNbPrestations(0);
        mou3ina.setN((float) Math.min(Math.max(mou3ina.getN(), 0.02), 0.1));  // sets default value to 2%, and maximum value to 10%
        mou3ina.setM((float) Math.min(Math.max(mou3ina.getM(), 0.1), 0.2));
        float salary = (float) (mou3ina.getFixedPart() + (mou3ina.getN() * mou3ina.getNbfavoris().doubleValue() * mou3ina.getFixedPart()) + ((mou3ina.getNbPrestations().doubleValue()/ 31) * mou3ina.getM() * mou3ina.getFixedPart()));
        mou3inaRepository.save(mou3ina);
        cleaningCompanyRepository.save(company);
        System.out.println(("Mou3ina added to company successfully."));
    }

    public List<Mou3inaEntity> getMou3inaListByCompanyId(Long companyId) {
        CleaningServicesCompany company = cleaningCompanyRepository.findById(companyId).orElseThrow(() -> new EntityNotFoundException("CleaningServicesCompany not found with id " + companyId));
        return new ArrayList<>(company.getProviders());
    }
}
