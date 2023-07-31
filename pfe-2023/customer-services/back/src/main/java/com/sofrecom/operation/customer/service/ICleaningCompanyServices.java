package com.sofrecom.operation.customer.service;

import com.sofrecom.operation.customer.entities.Mou3inaEntity;

import java.util.Set;

public interface ICleaningCompanyServices {
    public Set<Mou3inaEntity> getMou3inaListByCompanyId(Long companyId) ;

    public  void addMou3inaToCompany(Long id, Mou3inaEntity mou3ina);


}
