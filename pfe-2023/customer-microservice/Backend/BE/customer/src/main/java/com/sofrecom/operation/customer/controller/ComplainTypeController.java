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

import com.sofrecom.operation.customer.entities.ComplainType;
import com.sofrecom.operation.customer.service.ComplainTypeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ComplainTypeController {
	@Autowired
	ComplainTypeService complainTypeService;

	@GetMapping(value = "/complains")
	public List<ComplainType> findAllComplainType() {
		return complainTypeService.findAll();
	}

	@GetMapping(value = "/complains/{id}")
	public ComplainType findoneComplainType(@PathVariable Long id) {
		return complainTypeService.findComplainType(id);
	}
	
	@PostMapping(value ="/complains")
	public ComplainType addComplainType(@RequestBody ComplainType m) {
		return complainTypeService.addComplainType(m);
	}

	
	@PutMapping(value ="/complains/{id}")
	public ComplainType updateComplainType(@PathVariable Long id, @RequestBody ComplainType p) {
	p.setId(id);
		return complainTypeService.updateComplainType(p);
		
	}

	@DeleteMapping(value = "/complains/{id}")
	public void deleteComplainType(@PathVariable Long id) {
		complainTypeService.deleteComplainType(id);
	}

}

  
