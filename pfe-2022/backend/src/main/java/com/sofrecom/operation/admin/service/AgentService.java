package com.sofrecom.operation.admin.service;

import java.util.Collection;
import java.util.List;

import com.sofrecom.operation.admin.entities.Agent;

public interface AgentService {
	public Agent addAgent(Agent m);

	public void deleteAgent(Long id);

	public Agent updateAgent(Agent p);

	public Agent findAgent(Long id);

	public List<Agent> findAll();
	// Filtrage par propriété
	// public Collection<Delegation> findDelegationByStatus(Long idgouv);
}
