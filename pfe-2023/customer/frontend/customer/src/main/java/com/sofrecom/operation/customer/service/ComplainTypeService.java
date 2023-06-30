package com.sofrecom.operation.customer.service;

import java.util.List;

import com.sofrecom.operation.customer.entities.ComplainType;


public interface ComplainTypeService {
	
		

	public ComplainType addComplainType(ComplainType m);

	public void deleteComplainType(Long id);

	public ComplainType updateComplainType(ComplainType p);

	public ComplainType findComplainType(Long id);

	public List<ComplainType> findAll();

}
