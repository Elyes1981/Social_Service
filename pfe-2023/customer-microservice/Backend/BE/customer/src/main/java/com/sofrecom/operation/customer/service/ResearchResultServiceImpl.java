package com.sofrecom.operation.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofrecom.operation.customer.dao.ResearchResultRepository;
import com.sofrecom.operation.customer.entities.ResearchResult;

@Service

public class ResearchResultServiceImpl implements ResearchResultService {
	@Autowired
	ResearchResultRepository researchResultRepository;

	public ResearchResult addResearchResult(ResearchResult m) {
		return researchResultRepository.save(m);
	}

	public void deleteResearchResult(Long id) {
		if (researchResultRepository.findById(id).isPresent())
			researchResultRepository.deleteById(id);
	}

	public ResearchResult updateResearchResult(ResearchResult p) {
		return researchResultRepository.saveAndFlush(p);
	}

	public ResearchResult findResearchResult(Long id) {
		return researchResultRepository.findById(id).get();
	}

	public List<ResearchResult> findAll() {
		return researchResultRepository.findAll();
	}

	

	

}
