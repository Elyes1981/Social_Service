package com.sofrecom.operation.customer.service;

import java.util.List;

import com.sofrecom.operation.customer.entities.CooptedByType;


public interface CooptedByTypeService {
	
		

	public CooptedByType addCooptedByType(CooptedByType m);

	public void deleteCooptedByType(Long id);

	public CooptedByType updateCooptedByType(CooptedByType p);

	public CooptedByType findCooptedByType(Long id);

	public List<CooptedByType> findAll();

}
