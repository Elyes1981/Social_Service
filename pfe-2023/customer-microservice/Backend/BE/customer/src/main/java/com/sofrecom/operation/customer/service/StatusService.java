package com.sofrecom.operation.customer.service;

import java.util.List;

import com.sofrecom.operation.customer.entities.Status;

public interface StatusService {
	public Status addStatus(Status m);

	public void deleteStatus(Long id);

	public Status updateStatus(Status p);

	public Status findStatus(Long id);

	public List<Status> findAll();
	// Filtrage par propriété
	// public Collection<Delegation> findDelegationByStatus(Long idgouv);
}
