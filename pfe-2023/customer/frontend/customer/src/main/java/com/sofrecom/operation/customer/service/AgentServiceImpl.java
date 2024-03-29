package com.sofrecom.operation.customer.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofrecom.operation.customer.dao.AgentRepository;
import com.sofrecom.operation.customer.dao.GenderRepository;
import com.sofrecom.operation.customer.entities.Agent;
import com.sofrecom.operation.customer.entities.Gender;




@Service
public class AgentServiceImpl implements AgentService {
	@Autowired
	AgentRepository agentRepository;
	

	public Agent addAgent(Agent m) {
		return agentRepository.save(m);
	}

	public void deleteAgent(Long id) {
		if (agentRepository.findById(id).isPresent())
			agentRepository.deleteById(id);
	}

	public Agent updateAgent(Agent p) {
		return agentRepository.saveAndFlush(p);
	}

	public Agent findAgent(Long id) {
		return agentRepository.findById(id).get();
	}

	public List<Agent> findAll() {
		return agentRepository.findAll();
	}



}
