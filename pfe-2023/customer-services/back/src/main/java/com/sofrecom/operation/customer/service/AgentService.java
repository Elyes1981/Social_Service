package com.sofrecom.operation.customer.service;

import com.sofrecom.operation.customer.entities.Agent;

import java.util.List;

public interface AgentService {
	public Agent addAgent(Agent m);

	public void deleteAgent(Long id);

	public Agent updateAgent(Agent p);

	public Agent findAgent(Long id);

	public List<Agent> findAll();
	// Filtrage par propriété
	// public Collection<Delegation> findDelegationByStatus(Long idgouv);
}
