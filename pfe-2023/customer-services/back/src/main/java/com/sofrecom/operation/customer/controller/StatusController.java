package com.sofrecom.operation.customer.controller;

import java.util.List;

import com.sofrecom.operation.customer.entities.Status;
import com.sofrecom.operation.customer.service.StatusService;
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
public class StatusController {
	@Autowired
    StatusService statusService;

	@GetMapping(value = "/statuss")
	public List<Status> findAllstatusss() {
		return statusService.findAll();
	}

	@GetMapping(value = "/statuss/{id}")
	public Status findoneStatus(@PathVariable Long id) {
		return statusService.findStatus(id);
	}

	@PostMapping(value ="/statuss")
	public Status addStatus(@RequestBody Status m) {
		return statusService.addStatus(m);
	}

	
	@PutMapping(value ="/statuss/{id}")
	public Status updateStatus(@PathVariable Long id, @RequestBody Status p) {
	p.setId(id);
		return statusService.updateStatus(p);
		
	}

	@DeleteMapping(value = "/statuss/{id}")
	public void deleteStatus(@PathVariable Long id) {
		statusService.deleteStatus(id);
	}

}
