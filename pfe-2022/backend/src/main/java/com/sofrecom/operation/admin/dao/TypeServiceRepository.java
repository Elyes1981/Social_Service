package com.sofrecom.operation.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sofrecom.operation.admin.entities.ServiceType;


@Repository
public interface TypeServiceRepository  extends JpaRepository<ServiceType, Long> {
	

}
