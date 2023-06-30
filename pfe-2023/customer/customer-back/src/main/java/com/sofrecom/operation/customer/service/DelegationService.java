package com.sofrecom.operation.customer.service;

import java.util.Collection;

import com.sofrecom.operation.customer.entities.Delegation;


public interface DelegationService {
	public Delegation addDelegation(Delegation m);
	public void deleteDelegation(Long id) ;
	public Delegation updateDelegation(Delegation p) ;
	public Delegation findDelegation(Long id) ;
	public Collection<Delegation> findAll();

	//Filtrage par propriété

}
