package com.sofrecom.operation.admin.controller;

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

import com.sofrecom.operation.admin.entities.Gouvernorat;
import com.sofrecom.operation.admin.service.GouvernoratService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GouvernoratController {
	@Autowired
	GouvernoratService gouvernoratService;

	@GetMapping(value = "/gouvernorats")
	public List<Gouvernorat> findAllgouvernorats() {
		return gouvernoratService.findAll();
	}

	@GetMapping(value = "/gouvernorats/{id}")
	public Gouvernorat findoneGouvernorat(@PathVariable Long id) {
		return gouvernoratService.findGouvernorat(id);
	}

	@PostMapping(value ="/gouvernorats")
	public Gouvernorat addGouvernorat(@RequestBody Gouvernorat m) {
		return gouvernoratService.addGouvernorat(m);
	}

	
	@PutMapping(value ="/gouvernorats/{id}")
	public Gouvernorat updateGouvernorat(@PathVariable Long id, @RequestBody Gouvernorat p) {
	p.setIdgouv(id);
		return gouvernoratService.updateGouvernorat(p);
		
	}

	@DeleteMapping(value = "/gouvernorats/{id}")
	public void deleteGouvernorat(@PathVariable Long id) {
		gouvernoratService.deleteGouvernorat(id);
	}

}
