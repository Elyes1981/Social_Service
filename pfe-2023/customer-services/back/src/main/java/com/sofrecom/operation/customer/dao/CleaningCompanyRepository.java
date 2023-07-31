package com.sofrecom.operation.customer.dao;

import com.sofrecom.operation.customer.entities.CleaningServicesCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleaningCompanyRepository extends JpaRepository<CleaningServicesCompany, Long> {

}

