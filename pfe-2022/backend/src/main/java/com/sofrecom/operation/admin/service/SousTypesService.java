package com.sofrecom.operation.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sofrecom.operation.admin.entities.SousTypes;


public interface SousTypesService {
	
		

	public SousTypes addSousTypes(SousTypes m);

	public void deleteSousTypes(Long id);

	public SousTypes updateSousTypes(SousTypes p);

	public SousTypes findSousTypes(Long id);

	public List<SousTypes> findAll();

}
