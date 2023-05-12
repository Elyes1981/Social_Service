package com.sofrecom.authentifmou3ina.services;
import com.sofrecom.authentifmou3ina.entities.Delegation;

import java.util.List;



public interface IDelegationService {
	public Delegation addDelegation(Delegation m);

	public void deleteDelegation(Long id);

	public Delegation  updateDelegation (Delegation m);

	public Delegation  findDelegation (Long id);

	public List<Delegation> findAll();

}
