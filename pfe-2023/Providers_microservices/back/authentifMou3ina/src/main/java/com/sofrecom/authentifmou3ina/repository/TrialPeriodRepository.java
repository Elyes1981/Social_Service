package com.sofrecom.authentifmou3ina.repository;


import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.entities.TrialPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TrialPeriodRepository extends JpaRepository<TrialPeriod, Long> {

    TrialPeriod  findByMou3inaInterview (Mou3inaEntity mou3ina);

}
