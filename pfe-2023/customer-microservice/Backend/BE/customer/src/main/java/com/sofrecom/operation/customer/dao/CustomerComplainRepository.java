package com.sofrecom.operation.customer.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;


import com.sofrecom.operation.customer.entities.CustomerComplain;

public interface CustomerComplainRepository extends JpaRepository<CustomerComplain, Long> {

	@Query("SELECT i FROM CustomerComplain i where i.customer.id=:id")
	List<CustomerComplain> findByCustomer(Long id);


	

}
