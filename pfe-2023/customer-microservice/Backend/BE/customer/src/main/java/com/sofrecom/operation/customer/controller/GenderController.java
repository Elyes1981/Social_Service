package com.sofrecom.operation.customer.controller;

import java.util.List;

import com.sofrecom.operation.customer.entities.Gender;
import com.sofrecom.operation.customer.service.GenderService;
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
public class GenderController {
	@Autowired
    GenderService genderService;

	@GetMapping(value = "/genders")
	public List<Gender> findAllgender() {
		return genderService.findAll();
	}

	@GetMapping(value = "/genders/{id}")
	public Gender findoneGender(@PathVariable Long id) {
		return genderService.findGender(id);
	}

	@PostMapping(value ="/genders")
	public Gender addGender(@RequestBody Gender m) {
		return genderService.addGender(m);
	}

	
	@PutMapping(value ="/genders/{id}")
	public Gender updateGender(@PathVariable Long id, @RequestBody Gender p) {
	p.setId(id);
		return genderService.updateGender(p);
		
	}

	@DeleteMapping(value = "/genders/{id}")
	public void deleteGender(@PathVariable Long id) {
		genderService.deleteGender(id);
	}

}
