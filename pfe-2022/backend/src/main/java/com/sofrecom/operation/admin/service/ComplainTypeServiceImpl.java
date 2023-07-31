package com.sofrecom.operation.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofrecom.operation.admin.dao.ComplainTypeRepository;
import com.sofrecom.operation.admin.entities.ComplainType;



@Service
public class ComplainTypeServiceImpl implements ComplainTypeService {
	@Autowired
	
	ComplainTypeRepository complainTypeRepository;

	public ComplainType addComplainType(ComplainType m) {
		return complainTypeRepository.save(m);
	}

	public void deleteComplainType(Long id) {
		if (complainTypeRepository.findById(id).isPresent())
			complainTypeRepository.deleteById(id);
	}

	public ComplainType updateComplainType(ComplainType p) {
		return complainTypeRepository.saveAndFlush(p);
	}
	
	public ComplainType findComplainType(Long id) {
		return complainTypeRepository.findById(id).get();
	}

	public List<ComplainType> findAll() {
		return complainTypeRepository.findAll();
	}
	
	
	
	
	
}
