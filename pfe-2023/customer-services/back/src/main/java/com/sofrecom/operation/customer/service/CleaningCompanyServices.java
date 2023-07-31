package com.sofrecom.operation.customer.service;

import com.sofrecom.operation.customer.dao.CleaningCompanyRepository;
import com.sofrecom.operation.customer.dao.Mou3inaRepository;
import com.sofrecom.operation.customer.entities.CleaningServicesCompany;
import com.sofrecom.operation.customer.entities.EmploymentStatus;
import com.sofrecom.operation.customer.entities.Mou3inaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;


@Service
public class CleaningCompanyServices implements  ICleaningCompanyServices {

    @Autowired
    CleaningCompanyRepository cleaningCompanyRepository ;

    @Autowired
    Mou3inaRepository mou3inaRepository ;

    public Set<Mou3inaEntity> getMou3inaListByCompanyId(Long companyId) {
        Optional<CleaningServicesCompany> optionalCompany = cleaningCompanyRepository.findById(companyId);
        CleaningServicesCompany company = optionalCompany.get();
        Set<Mou3inaEntity> providers = company.getProviders();
        return providers;
    }

    @Override
    public void addMou3inaToCompany(Long id, Mou3inaEntity mou3ina) {
        CleaningServicesCompany company=(CleaningServicesCompany) cleaningCompanyRepository.findById(id).get();
        company.getProviders().add(mou3ina);
        mou3ina.setEmploymentStatus(EmploymentStatus.salaried_employee);
        mou3ina.setNbfavoris(0);
        mou3ina.setNbServicesDone(0);
        mou3inaRepository.save(mou3ina);
        cleaningCompanyRepository.save(company);
        System.out.println(("Mou3ina added to company successfully."));
    }
}
