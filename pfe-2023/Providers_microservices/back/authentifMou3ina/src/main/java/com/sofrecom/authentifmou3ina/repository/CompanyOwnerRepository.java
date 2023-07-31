package com.sofrecom.authentifmou3ina.repository;

import com.sofrecom.authentifmou3ina.entities.CleaningServicesCompany;
import com.sofrecom.authentifmou3ina.entities.CompanyOwners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyOwnerRepository extends JpaRepository<CompanyOwners, Long> {
}
