package com.sofrecom.operation.customer.controller;


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

import com.sofrecom.operation.customer.entities.CooptedByType;

import com.sofrecom.operation.customer.service.CooptedByTypeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CooptedByTypeController {
	@Autowired
	CooptedByTypeService cooptedbytypeService;

	@GetMapping(value = "/cooptedbys")
	public List<CooptedByType> findAllcooptedbytype() {
		return cooptedbytypeService.findAll();
	}

	@GetMapping(value = "/cooptedbys/{id}")
	public CooptedByType findonecooptedbytype(@PathVariable Long id) {
		return cooptedbytypeService.findCooptedByType(id);
	}
	
	@PostMapping(value ="/cooptedbys")
	public CooptedByType addCooptedByType(@RequestBody CooptedByType m) {
		return cooptedbytypeService.addCooptedByType(m);
	}

	
	@PutMapping(value ="/cooptedbys/{id}")
	public CooptedByType updateCooptedByType(@PathVariable Long id, @RequestBody CooptedByType p) {
	p.setId(id);
		return cooptedbytypeService.updateCooptedByType(p);
		
	}

	@DeleteMapping(value = "/cooptedbys/{id}")
	public void deleteCooptedByType(@PathVariable Long id) {
		cooptedbytypeService.deleteCooptedByType(id);
	}

}

  
