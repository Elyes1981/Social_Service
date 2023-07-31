package com.sofrecom.authentifmou3ina.controller;

import java.util.List;

import com.sofrecom.authentifmou3ina.entities.Status;
import com.sofrecom.authentifmou3ina.services.IStatusService;
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
public class StatusController {
	@Autowired
	IStatusService iStatusService;
	@RequestMapping(value = "/Status", method = RequestMethod.GET)
	public List<Status> findStatus() {
		return iStatusService.findAll();
	}
	@GetMapping(value = "/Status/{id}")
	public Status findOneStatusById(@PathVariable Long id) {
		return iStatusService.findStatus(id);
	}
	@PostMapping(value = "/Status/newStatus")
	public Status addStatus(@RequestBody Status m) {
		return iStatusService.addStatus(m);
	}
	@PutMapping(value = "/Statuss/Status/{id}")
	public Status updateStatus(@PathVariable Long id, @RequestBody Status p) {
		p.setId(id);
		return iStatusService.updateStatus(p);
	}

	@DeleteMapping(value = "/deleteStatus/{id}")
	public void deleteStatus(@PathVariable Long id) {
		iStatusService.deleteStatus(id);
	}


	

	
}




