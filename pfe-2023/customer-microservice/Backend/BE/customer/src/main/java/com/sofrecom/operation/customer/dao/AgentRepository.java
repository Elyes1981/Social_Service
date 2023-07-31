package com.sofrecom.operation.customer.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofrecom.operation.customer.entities.Agent;
import com.sofrecom.operation.customer.entities.Gender;




public interface AgentRepository extends JpaRepository<Agent, Long> {
	
	
	

}
