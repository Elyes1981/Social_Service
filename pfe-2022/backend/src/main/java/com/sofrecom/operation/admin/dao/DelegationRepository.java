package com.sofrecom.operation.admin.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofrecom.operation.admin.entities.Delegation;



public interface DelegationRepository extends JpaRepository<Delegation, Long> {
	
	
}
