package com.sofrecom.operation.customer.controller;


import java.util.List;

import com.sofrecom.operation.customer.entities.SousTypes;
import com.sofrecom.operation.customer.service.SousTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SousTypesController {
	@Autowired
    SousTypesService sousTypesService;

	@GetMapping(value = "/soustypes")
	public List<SousTypes> findAllSousTypes() {
		return sousTypesService.findAll();
	}

	@GetMapping(value = "/soustypes/{id}")
	public SousTypes findoneSousTypes(@PathVariable Long id) {
		return sousTypesService.findSousTypes(id);
	}
	
	@PostMapping(value ="/soustypes")
	public SousTypes addSousTypes(@RequestBody SousTypes m) {
		return sousTypesService.addSousTypes(m);
	}

	
	@PutMapping(value ="/soustypes/{id}")
	public SousTypes updateSousTypes(@PathVariable Long id, @RequestBody SousTypes p) {
	p.setIdsous(id);
		return sousTypesService.updateSousTypes(p);
		
	}

	@DeleteMapping(value = "/soustypes/{id}")
	public void deleteSousTypes(@PathVariable Long id) {
		sousTypesService.deleteSousTypes(id);
	}

}

  
