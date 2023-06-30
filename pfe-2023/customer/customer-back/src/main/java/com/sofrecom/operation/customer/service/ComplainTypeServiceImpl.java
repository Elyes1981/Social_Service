package com.sofrecom.operation.customer.service;

import java.util.List;

import com.sofrecom.operation.customer.dao.ComplainTypeRepository;
import com.sofrecom.operation.customer.entities.ComplainType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
