package com.sofrecom.operation.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofrecom.operation.admin.entities.ComplainType;
import com.sofrecom.operation.admin.entities.SousTypes;

public interface SousTypesRepository extends JpaRepository<SousTypes, Long> {
	

}
