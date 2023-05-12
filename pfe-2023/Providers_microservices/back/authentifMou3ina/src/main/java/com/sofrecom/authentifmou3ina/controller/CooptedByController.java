package com.sofrecom.authentifmou3ina.controller;

import java.util.List;

import com.sofrecom.authentifmou3ina.entities.CooptedBy;
import com.sofrecom.authentifmou3ina.services.ICooptedByService;
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
public class CooptedByController {
	@Autowired
	ICooptedByService iCooptedByService;
	@RequestMapping(value = "/CooptedBy", method = RequestMethod.GET)
	public List<CooptedBy> findcooptedBy() {
		return iCooptedByService.findAll();
	}
	@GetMapping(value = "/CooptedBy/{id}")
	public CooptedBy findOnecooptedByById(@PathVariable Long id) {
		return iCooptedByService.findcooptedBy(id);
	}
	@PostMapping(value = "/CooptedBy/newCooptedBy")
	public CooptedBy addcooptedBy(@RequestBody CooptedBy m) {
		return iCooptedByService.addcooptedBy(m);
	}
	@PutMapping(value = "/CooptedBys/CooptedBy/{id}")
	public CooptedBy updateCooptedBy(@PathVariable Long id, @RequestBody CooptedBy p) {
		p.setId(id);
		return iCooptedByService.updatecooptedBy(p);
	}

	@DeleteMapping(value = "/deletecooptedBy/{id}")
	public void deletecooptedBy(@PathVariable Long id) {
		iCooptedByService.deletecooptedBy(id);
	}


	

}
