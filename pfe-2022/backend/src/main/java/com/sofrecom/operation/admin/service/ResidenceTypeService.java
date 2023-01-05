package com.sofrecom.operation.admin.service;

import java.util.Collection;
import java.util.List;

import com.sofrecom.operation.admin.entities.ResidenceType;

public interface ResidenceTypeService {
	public ResidenceType addResidenceType(ResidenceType m);

	public void deleteResidenceType(Long id);

	public ResidenceType updateResidenceType(ResidenceType p);

	public ResidenceType findResidenceType(Long id);

	public List<ResidenceType> findAll();
	// Filtrage par propriété
	// public Collection<Delegation> findDelegationByStatus(Long idgouv);
}
