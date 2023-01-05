package com.sofrecom.operation.admin.service;

import java.util.Collection;
import java.util.List;

import com.sofrecom.operation.admin.entities.Delegation;



public interface DelegationService {
	public Delegation addDelegation(Delegation m);
	public void deleteDelegation(Long id) ;
	public Delegation updateDelegation(Delegation p) ;
	public Delegation findDelegation(Long id) ;
	public Collection<Delegation> findAll();

	//Filtrage par propriété

}
