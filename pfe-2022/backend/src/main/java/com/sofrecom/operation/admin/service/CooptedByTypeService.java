package com.sofrecom.operation.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sofrecom.operation.admin.entities.CooptedByType;


public interface CooptedByTypeService {
	
		

	public CooptedByType addCooptedByType(CooptedByType m);

	public void deleteCooptedByType(Long id);

	public CooptedByType updateCooptedByType(CooptedByType p);

	public CooptedByType findCooptedByType(Long id);

	public List<CooptedByType> findAll();

}
