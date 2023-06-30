package com.sofrecom.operation.customer.dao;

import com.sofrecom.operation.customer.entities.CustomerReservation;
import com.sofrecom.operation.customer.entities.ResearchResult;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

public interface ResearchResultRepository extends JpaRepository<ResearchResult, Long> {
	
	
	


}
