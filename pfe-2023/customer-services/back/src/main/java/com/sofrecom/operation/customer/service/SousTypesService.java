package com.sofrecom.operation.customer.service;

import java.util.List;

import com.sofrecom.operation.customer.entities.SousTypes;


public interface SousTypesService {
	
		

	public SousTypes addSousTypes(SousTypes m);

	public void deleteSousTypes(Long id);

	public SousTypes updateSousTypes(SousTypes p);

	public SousTypes findSousTypes(Long id);

	public List<SousTypes> findAll();

}
