package com.sofrecom.authentifmou3ina.services;
import java.util.List;

import com.sofrecom.authentifmou3ina.entities.Gouvernorat;
import com.sofrecom.authentifmou3ina.repository.GouvernoratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class gouverImps implements IGouvernoratService {
	@Autowired
	GouvernoratRepository gouvernoratRepository;
	@Override
	public Gouvernorat addGouvernorat(Gouvernorat m) {
		gouvernoratRepository.save(m);
		return m;
	}

	@Override
	public void deleteGouvernorat(Long id) {
		if(gouvernoratRepository.findById(id).isPresent())
			gouvernoratRepository.deleteById(id);
		
	}

	@Override
	public Gouvernorat updateGouvernorat(Gouvernorat m) {
		return gouvernoratRepository.saveAndFlush(m);
	}

	@Override
	public Gouvernorat findGouvernorat(Long id) {
		Gouvernorat m=(Gouvernorat) gouvernoratRepository.findById(id).get();
		  return m;}
	

	@Override
	public List<Gouvernorat> findAll() {
		return gouvernoratRepository.findAll();
	}
	
}
