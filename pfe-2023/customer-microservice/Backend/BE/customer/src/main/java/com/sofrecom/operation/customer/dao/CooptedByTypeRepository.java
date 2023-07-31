package com.sofrecom.operation.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sofrecom.operation.customer.entities.CooptedByType;

public interface CooptedByTypeRepository extends JpaRepository<CooptedByType, Long> {
	

}
