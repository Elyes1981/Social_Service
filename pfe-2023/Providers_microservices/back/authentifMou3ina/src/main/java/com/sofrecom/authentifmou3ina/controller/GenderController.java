package com.sofrecom.authentifmou3ina.controller;

import java.util.List;

import com.sofrecom.authentifmou3ina.entities.Gender;
import com.sofrecom.authentifmou3ina.services.IGender;
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
public class GenderController {
	@Autowired
	IGender igenderService;
	@RequestMapping(value = "/Gender", method = RequestMethod.GET)
	public List<Gender> findGender() {
		return igenderService.findAll();
	}
	@GetMapping(value = "/Gender/{id}")
	public Gender findOneGendersById(@PathVariable Long id) {
		return igenderService.findGender(id);
	}
	@PostMapping(value = "/Gender/newGender")
	public Gender addGender(@RequestBody Gender m) {
		return igenderService.addGender(m);
	}
	@PutMapping(value = "/Genders/Gender/{id}")
	public Gender updateGender(@PathVariable Long id, @RequestBody Gender p) {
		p.setId(id);
		return igenderService.updateGender(p);
	}

	@DeleteMapping(value = "/deleteGender/{id}")
	public void deleteGender(@PathVariable Long id) {
		igenderService.deleteGender(id);
	}


	

	
}


