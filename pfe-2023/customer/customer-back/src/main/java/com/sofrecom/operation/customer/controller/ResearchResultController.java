package com.sofrecom.operation.customer.controller;

import com.sofrecom.operation.customer.entities.ResearchResult;
import com.sofrecom.operation.customer.service.ResearchResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ResearchResultController {

	@Autowired
	ResearchResultService researchResultService;

	@GetMapping(value = "/researchResults")
	
	public List<ResearchResult> findAllresearchResults() {
		return researchResultService.findAll();
	}

	@GetMapping(value = "/researchResults/{id}")
	public ResearchResult findoneResearchResult(@PathVariable Long id) {
		return researchResultService.findResearchResult(id);
	}
	
   

	@PostMapping(value ="/researchResults")
	public ResearchResult addResearchResult(@RequestBody ResearchResult m) {
		return researchResultService.addResearchResult(m);
	}

	

}
