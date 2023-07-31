package com.sofrecom.operation.admin.service;

import java.util.Collection;
import java.util.List;

import com.sofrecom.operation.admin.entities.Gouvernorat;

public interface GouvernoratService {
	public Gouvernorat addGouvernorat(Gouvernorat m);

	public void deleteGouvernorat(Long id);

	public Gouvernorat updateGouvernorat(Gouvernorat p);

	public Gouvernorat findGouvernorat(Long id);

	public List<Gouvernorat> findAll();
	// Filtrage par propriété
	// public Collection<Delegation> findDelegationByGouvernorat(Long idgouv);
}
