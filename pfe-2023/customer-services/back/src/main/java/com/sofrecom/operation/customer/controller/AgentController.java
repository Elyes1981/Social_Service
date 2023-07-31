package com.sofrecom.operation.customer.controller;

import com.sofrecom.operation.customer.entities.Agent;
import com.sofrecom.operation.customer.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



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
