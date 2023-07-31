package com.sofrecom.operation.admin.service;

import java.util.Collection;
import java.util.List;

import com.sofrecom.operation.admin.entities.Status;

public interface StatusService {
	public Status addStatus(Status m);

	public void deleteStatus(Long id);

	public Status updateStatus(Status p);

	public Status findStatus(Long id);

	public List<Status> findAll();
	// Filtrage par propriété
	// public Collection<Delegation> findDelegationByStatus(Long idgouv);
}
