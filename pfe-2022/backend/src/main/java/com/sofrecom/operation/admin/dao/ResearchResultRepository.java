package com.sofrecom.operation.admin.dao;

import com.sofrecom.operation.admin.entities.CustomerReservation;
import com.sofrecom.operation.admin.entities.ResearchResult;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

public interface ResearchResultRepository extends JpaRepository<ResearchResult, Long> {
	
	
	


}
