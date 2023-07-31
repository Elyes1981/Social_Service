package com.sofrecom.operation.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sofrecom.operation.admin.entities.CooptedByType;

public interface CooptedByTypeRepository extends JpaRepository<CooptedByType, Long> {
	

}
