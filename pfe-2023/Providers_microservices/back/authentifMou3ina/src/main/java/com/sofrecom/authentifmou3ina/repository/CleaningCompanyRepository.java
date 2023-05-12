package com.sofrecom.authentifmou3ina.repository;

import com.sofrecom.authentifmou3ina.entities.CleaningServicesCompany;
import com.sofrecom.authentifmou3ina.entities.Interview;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CleaningCompanyRepository extends JpaRepository<CleaningServicesCompany, Long> {

    Boolean existsByUsername(String username);
    Boolean existsByemailAdress(String emailAdress);

    Optional<CleaningServicesCompany> findByUsername(String username);

}
