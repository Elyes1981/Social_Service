package com.sofrecom.authentifmou3ina.services;
import com.sofrecom.authentifmou3ina.entities.Gouvernorat;

import java.util.List;



public interface IGouvernoratService {
	public Gouvernorat addGouvernorat(Gouvernorat m);

	public void deleteGouvernorat(Long id);

	public Gouvernorat  updateGouvernorat (Gouvernorat m);

	public Gouvernorat  findGouvernorat (Long id);
	

	


	
	
	public List<Gouvernorat> findAll();

}
