package com.sofrecom.authentifmou3ina.services;

import com.sofrecom.authentifmou3ina.entities.Seniority;

import java.util.List;




public interface ISeniorityService {
	public Seniority addseniority(Seniority m);

	public void deleteseniority(Long id);

	public Seniority  updateseniority (Seniority m);

	public Seniority  findseniority (Long id);
	

	


	
	
	public List<Seniority> findAll();
}
