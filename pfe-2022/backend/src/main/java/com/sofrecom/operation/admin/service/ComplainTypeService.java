package com.sofrecom.operation.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sofrecom.operation.admin.entities.ComplainType;


public interface ComplainTypeService {
	
		

	public ComplainType addComplainType(ComplainType m);

	public void deleteComplainType(Long id);

	public ComplainType updateComplainType(ComplainType p);

	public ComplainType findComplainType(Long id);

	public List<ComplainType> findAll();

}
