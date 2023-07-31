package com.sofrecom.authentifmou3ina.controller;

import java.util.List;

import com.sofrecom.authentifmou3ina.entities.Delegation;
import com.sofrecom.authentifmou3ina.services.IDelegationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins="http://localhost:4200")
@RestController
public class DelegationController {
	@Autowired
	IDelegationService iDelegationService;
	@GetMapping("/Delegations")
	public List<Delegation> findDelegation() {
		return iDelegationService.findAll();
	}
	@GetMapping(value = "/Delegation/{id}")
	public Delegation findOneDelegationsById(@PathVariable Long id) {
		return iDelegationService.findDelegation(id);
	}
	@PostMapping(value = "/Delegation/newDelegation")
	public Delegation addDelegation(@RequestBody Delegation m) {
		return iDelegationService.addDelegation(m);
	}
	@PutMapping(value = "/Delegations/Delegation/{id}")
	public Delegation updateDelegation(@PathVariable Long id, @RequestBody Delegation p) {
		p.setIdDeleg(id);
		return iDelegationService.updateDelegation(p);
	}

	@DeleteMapping(value = "/deleteDelegation/{id}")
	public void deleteDelegation(@PathVariable Long id) {
		iDelegationService.deleteDelegation(id);
	}


	

	
}
