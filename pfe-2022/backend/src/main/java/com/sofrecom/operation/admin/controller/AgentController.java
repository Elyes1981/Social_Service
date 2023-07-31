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

import com.sofrecom.operation.admin.entities.Agent;
import com.sofrecom.operation.admin.service.AgentService;
import com.sofrecom.operation.admin.service.StatusService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AgentController {
	@Autowired
	AgentService agentService;

	@GetMapping(value = "/agents")
	public List<Agent> findAllagents() {
		return agentService.findAll();
	}

	@GetMapping(value = "/agents/{id}")
	public Agent findoneAgent(@PathVariable Long id) {
		return agentService.findAgent(id);
	}

	@PostMapping(value ="/agents")
	public Agent addAgent(@RequestBody Agent m) {
		return agentService.addAgent(m);
	}

	
	@PutMapping(value ="/agents/{id}")
	public Agent updateAgent(@PathVariable Long id, @RequestBody Agent p) {
	p.setId(id);
		return agentService.updateAgent(p);
		
	}

	@DeleteMapping(value = "/agents/{id}")
	public void deleteAgent(@PathVariable Long id) {
		agentService.deleteAgent(id);
	}

}
