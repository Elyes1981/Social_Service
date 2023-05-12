package com.sofrecom.authentifmou3ina.controller;

import java.util.List;

import com.sofrecom.authentifmou3ina.entities.Gouvernorat;
import com.sofrecom.authentifmou3ina.services.IGouvernoratService;
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




@CrossOrigin
@RestController
public class GouvernoratController {
	@Autowired
	IGouvernoratService iGouvernoratService;
	@RequestMapping(value = "/Gouvernorats", method = RequestMethod.GET)
	public List<Gouvernorat> findGouvernorat() {
		return iGouvernoratService.findAll();
	}
	@GetMapping(value = "/Gouvernorat/{id}")
	public Gouvernorat findOneGouvernoratById(@PathVariable Long id) {
		return iGouvernoratService.findGouvernorat(id);
	}
	@PostMapping(value = "/Gouvernorat/newGouvernorat")
	public Gouvernorat addGouvernorat(@RequestBody Gouvernorat m) {
		return iGouvernoratService.addGouvernorat(m);
	}
	@PutMapping(value = "/Gouvernorats/Gouvernorat/{id}")
	public Gouvernorat updateGouvernorat(@PathVariable Long id, @RequestBody Gouvernorat p) {
		p.setIdGouvert(id);
		return iGouvernoratService.updateGouvernorat(p);
	}

	@DeleteMapping(value = "/deleteGouvernorat/{id}")
	public void deleteGouvernorat(@PathVariable Long id) {
		iGouvernoratService.deleteGouvernorat(id);
	}
}
