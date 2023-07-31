package com.sofrecom.authentifmou3ina.controller;

import java.util.List;

import com.sofrecom.authentifmou3ina.entities.Seniority;
import com.sofrecom.authentifmou3ina.services.ISeniorityService;
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
public class SeniorityController {
	@Autowired
	ISeniorityService iSeniorityService;
	
	@RequestMapping(value = "/Senioritys", method = RequestMethod.GET)
	public List<Seniority> findSeniority() {
		return iSeniorityService.findAll();
	}
	@GetMapping(value = "/Seniority/{id}")
	public Seniority findOneseniorityById(@PathVariable Long id) {
		return iSeniorityService.findseniority(id);
	}
	@PostMapping(value = "/Seniority/newSeniority")
	public Seniority addseniority(@RequestBody Seniority m) {
		return iSeniorityService.addseniority(m);
	}
	@PutMapping(value = "/SeniorityS/Seniority/{id}")
	public Seniority updateSeniority(@PathVariable Long id, @RequestBody Seniority p) {
		p.setId(id);
		return iSeniorityService.updateseniority(p);
	}

	@DeleteMapping(value = "/deleteSeniority/{id}")
	public void deleteseniority(@PathVariable Long id) {
		iSeniorityService.deleteseniority(id);
	}


	
}
