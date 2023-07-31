package com.sofrecom.operation.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofrecom.operation.admin.entities.ComplainType;

public interface ComplainTypeRepository extends JpaRepository<ComplainType, Long> {
	

}
