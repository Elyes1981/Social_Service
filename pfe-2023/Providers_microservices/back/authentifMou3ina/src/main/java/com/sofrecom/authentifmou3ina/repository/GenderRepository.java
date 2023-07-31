package com.sofrecom.authentifmou3ina.repository;

import com.sofrecom.authentifmou3ina.entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {

}
