package com.sofrecom.operation.customer.controller;

import java.util.List;

import com.sofrecom.operation.customer.entities.ResidenceType;
import com.sofrecom.operation.customer.service.ResidenceTypeService;
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
public class ResidenceTypeController {
	@Autowired
    ResidenceTypeService residenceTypeService;

	@GetMapping(value = "/residenceTypes")
	public List<ResidenceType> findAllresidenceTypess() {
		return residenceTypeService.findAll();
	}

	@GetMapping(value = "/residenceTypes/{id}")
	public ResidenceType findoneResidenceType(@PathVariable Long id) {
		return residenceTypeService.findResidenceType(id);
	}

	@PostMapping(value ="/residenceTypes")
	public ResidenceType addResidenceType(@RequestBody ResidenceType m) {
		return residenceTypeService.addResidenceType(m);
	}

	
	@PutMapping(value ="/residenceTypes/{id}")
	public ResidenceType updateResidenceType(@PathVariable Long id, @RequestBody ResidenceType p) {
	p.setId(id);
		return residenceTypeService.updateResidenceType(p);
		
	}

	@DeleteMapping(value = "/residenceTypes/{id}")
	public void deleteResidenceType(@PathVariable Long id) {
		residenceTypeService.deleteResidenceType(id);
	}

}
