package com.sofrecom.operation.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sofrecom.operation.admin.dao.ResearchResultRepository;
import com.sofrecom.operation.admin.entities.ResearchResult;
import com.sofrecom.operation.admin.service.ResearchResultService;

@CrossOrigin
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
