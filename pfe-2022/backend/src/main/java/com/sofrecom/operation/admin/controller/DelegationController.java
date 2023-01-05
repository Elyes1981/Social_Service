package com.sofrecom.operation.admin.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sofrecom.operation.admin.entities.Delegation;
import com.sofrecom.operation.admin.service.DelegationService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DelegationController {
	@Autowired
	DelegationService delegationService;

	@GetMapping(value = "/delegations")
	public Collection<Delegation> findAlldelegations() {
		return delegationService.findAll();
	}

	@GetMapping(value = "/delegations/{id}")
	public Delegation findoneDelegation(@PathVariable Long id) {
		return delegationService.findDelegation(id);
	}

	@PostMapping(value ="/delegations")
	public Delegation addDelegation(@RequestBody Delegation m) {
		return delegationService.addDelegation(m);
	}

	
	@PutMapping(value ="/delegations/{id}")
	public Delegation updateDelegation(@PathVariable Long id, @RequestBody Delegation p) {
	p.setIddele(id);
		return delegationService.updateDelegation(p);
		
	}

	@DeleteMapping(value = "/delegations/{id}")
	public void deleteDelegation(@PathVariable Long id) {
		delegationService.deleteDelegation(id);
	}

}
