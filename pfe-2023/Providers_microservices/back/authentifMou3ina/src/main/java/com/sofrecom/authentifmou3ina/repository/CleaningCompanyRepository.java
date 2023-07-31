package com.sofrecom.authentifmou3ina.repository;

import com.sofrecom.authentifmou3ina.entities.CleaningServicesCompany;
import com.sofrecom.authentifmou3ina.entities.Interview;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CleaningCompanyRepository extends JpaRepository<CleaningServicesCompany, Long> {

    Boolean existsByUsername(String username);
    Boolean existsByemailAdress(String emailAdress);

    Optional<CleaningServicesCompany> findByUsername(String username);

    @Modifying
    @Query("update CleaningServicesCompany m set m.logo =:logoPath where m.id =:id")
    public void updateLogoPath( Long id, String logoPath);

    CleaningServicesCompany findByCompanyID(String companyID);

    Optional<CleaningServicesCompany> findByProvidersId(Long providerId);







}
