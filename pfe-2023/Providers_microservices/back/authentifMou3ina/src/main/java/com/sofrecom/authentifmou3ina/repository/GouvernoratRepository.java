package com.sofrecom.authentifmou3ina.repository;

import com.sofrecom.authentifmou3ina.entities.Gouvernorat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository

public interface GouvernoratRepository extends JpaRepository<Gouvernorat, Long> {

}
