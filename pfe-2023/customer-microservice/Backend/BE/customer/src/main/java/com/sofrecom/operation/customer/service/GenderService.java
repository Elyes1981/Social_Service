package com.sofrecom.operation.customer.service;

import java.util.List;

import com.sofrecom.operation.customer.entities.Gender;

public interface GenderService {
	public Gender addGender(Gender m);

	public void deleteGender(Long id);

	public Gender updateGender(Gender p);

	public Gender findGender(Long id);

	public List<Gender> findAll();
	// Filtrage par propriété
	// public Collection<Delegation> findDelegationByStatus(Long idgouv);
}
