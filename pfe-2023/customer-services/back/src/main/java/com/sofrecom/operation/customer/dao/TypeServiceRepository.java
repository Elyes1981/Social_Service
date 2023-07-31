package com.sofrecom.operation.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sofrecom.operation.customer.entities.ServiceType;


@Repository
public interface TypeServiceRepository  extends JpaRepository<ServiceType, Long> {
	

}
