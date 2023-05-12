package com.sofrecom.authentifmou3ina.repository;

import com.sofrecom.authentifmou3ina.entities.Seniority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SeniorityRepository extends JpaRepository<Seniority, Long> {

}
