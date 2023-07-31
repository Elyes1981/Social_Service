package com.sofrecom.operation.customer.controller;

import com.sofrecom.operation.customer.entities.Gouvernorat;
import com.sofrecom.operation.customer.service.GouvernoratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
	p.setIdGouvert(id);
		return gouvernoratService.updateGouvernorat(p);
		
	}

	@DeleteMapping(value = "/gouvernorats/{id}")
	public void deleteGouvernorat(@PathVariable Long id) {
		gouvernoratService.deleteGouvernorat(id);
	}

}
