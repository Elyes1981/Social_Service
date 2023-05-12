package com.sofrecom.authentifmou3ina.repository;

import com.sofrecom.authentifmou3ina.entities.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TypeServiceRepository  extends JpaRepository<ServiceType, Long> {
	

}
