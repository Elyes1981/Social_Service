package com.sofrecom.operation.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofrecom.operation.customer.entities.ComplainType;

public interface ComplainTypeRepository extends JpaRepository<ComplainType, Long> {
	

}
