package com.sofrecom.authentifmou3ina.services;
import java.util.List;

import com.sofrecom.authentifmou3ina.entities.Delegation;
import com.sofrecom.authentifmou3ina.repository.DelegationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class delegationImp implements IDelegationService {
   
	@Autowired
	DelegationRepository delegationRepository;
	@Override
	public Delegation addDelegation(Delegation m) {
		return  delegationRepository.save(m);
	}

	@Override
	public void deleteDelegation(Long id) {
		if(delegationRepository.findById(id).isPresent())
			delegationRepository.deleteById(id);
		
	}

	@Override
	public Delegation updateDelegation(Delegation m) {
		return delegationRepository.saveAndFlush(m);
	}

	@Override
	public Delegation findDelegation(Long id) {
		Delegation m=(Delegation) delegationRepository.findById(id).get();
		  return m;
	}

	@Override
	public List<Delegation> findAll() {
		return delegationRepository.findAll();
	}
	


}
