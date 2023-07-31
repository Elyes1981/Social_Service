package com.sofrecom.operation.admin.service;

import java.util.List;

import com.sofrecom.operation.admin.entities.ResearchResult;

public interface ResearchResultService {
	public ResearchResult addResearchResult(ResearchResult m);
	public void deleteResearchResult(Long id) ;
	public ResearchResult updateResearchResult(ResearchResult p) ;
	public ResearchResult findResearchResult(Long id) ;
	public List<ResearchResult> findAll();
	//Filtrage par propriété
	
	
	
}
