package com.sofrecom.operation.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofrecom.operation.admin.dao.SousTypesRepository;
import com.sofrecom.operation.admin.entities.SousTypes;



@Service
public class SousTypesImpl implements SousTypesService {
	@Autowired
	
	SousTypesRepository sousTypesRepository;

	public SousTypes addSousTypes(SousTypes m) {
		return sousTypesRepository.save(m);
	}

	public void deleteSousTypes(Long id) {
		if (sousTypesRepository.findById(id).isPresent())
			sousTypesRepository.deleteById(id);
	}

	public SousTypes updateSousTypes(SousTypes p) {
		return sousTypesRepository.saveAndFlush(p);
	}
	
	public SousTypes findSousTypes(Long id) {
		return sousTypesRepository.findById(id).get();
	}

	public List<SousTypes> findAll() {
		return sousTypesRepository.findAll();
	}
	
	
	
	
	
}
