package com.sofrecom.operation.admin.service;

import java.util.Collection;
import java.util.List;

import com.sofrecom.operation.admin.entities.Gender;

public interface GenderService {
	public Gender addGender(Gender m);

	public void deleteGender(Long id);

	public Gender updateGender(Gender p);

	public Gender findGender(Long id);

	public List<Gender> findAll();
	// Filtrage par propriété
	// public Collection<Delegation> findDelegationByStatus(Long idgouv);
}
