package com.sofrecom.operation.customer.service;

import java.util.List;

import com.sofrecom.operation.customer.dao.DelegationRepository;
import com.sofrecom.operation.customer.dao.GouvernoratRepository;
import com.sofrecom.operation.customer.entities.Delegation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DelegationServiceImpl implements DelegationService {
	@Autowired
    DelegationRepository delegationRepository;
	@Autowired
    GouvernoratRepository gouvernoratRepository;

	public Delegation addDelegation(Delegation m) {
		return delegationRepository.save(m);
	}

	public void deleteDelegation(Long id) {
		if (delegationRepository.findById(id).isPresent())
			delegationRepository.deleteById(id);
	}

	public Delegation updateDelegation(Delegation p) {
		return delegationRepository.saveAndFlush(p);
	}

	public Delegation findDelegation(Long id) {
		return delegationRepository.findById(id).get();
	}

	public List<Delegation> findAll() {
		return delegationRepository.findAll();
	}
	

}
