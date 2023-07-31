package com.sofrecom.operation.customer.service;

import java.util.List;

import com.sofrecom.operation.customer.dao.SousTypesRepository;
import com.sofrecom.operation.customer.entities.SousTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
