package com.sofrecom.authentifmou3ina.services;
import com.sofrecom.authentifmou3ina.entities.Gender;

import java.util.List;



public interface IGender {
	public Gender addGender(Gender m);

	public void deleteGender(Long id);

	public Gender  updateGender (Gender m);

	public Gender  findGender (Long id);
	

	


	
	
	public List<Gender> findAll();

}
