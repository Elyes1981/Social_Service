package com.sofrecom.operation.admin.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofrecom.operation.admin.entities.Agent;
import com.sofrecom.operation.admin.entities.Gender;




public interface AgentRepository extends JpaRepository<Agent, Long> {
	
	
	

}
