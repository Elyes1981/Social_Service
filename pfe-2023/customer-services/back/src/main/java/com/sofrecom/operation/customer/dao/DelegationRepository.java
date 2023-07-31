package com.sofrecom.operation.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofrecom.operation.customer.entities.Delegation;



public interface DelegationRepository extends JpaRepository<Delegation, Long> {
	
	
}
