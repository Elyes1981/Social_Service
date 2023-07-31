package com.sofrecom.authentifmou3ina.repository;

import com.sofrecom.authentifmou3ina.entities.CooptedBy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CooptedByRepository extends JpaRepository<CooptedBy, Long> {

}
