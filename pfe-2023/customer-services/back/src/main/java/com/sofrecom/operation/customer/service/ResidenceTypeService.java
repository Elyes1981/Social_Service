package com.sofrecom.operation.customer.service;

import java.util.List;

import com.sofrecom.operation.customer.entities.ResidenceType;

public interface ResidenceTypeService {
	public ResidenceType addResidenceType(ResidenceType m);

	public void deleteResidenceType(Long id);

	public ResidenceType updateResidenceType(ResidenceType p);

	public ResidenceType findResidenceType(Long id);

	public List<ResidenceType> findAll();
	// Filtrage par propriété
	// public Collection<Delegation> findDelegationByStatus(Long idgouv);
}
