package com.sofrecom.operation.customer.service;

import java.util.List;

import com.sofrecom.operation.customer.dao.ResidenceTypeRepository;
import com.sofrecom.operation.customer.entities.ResidenceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ResidenceTypeServiceImpl implements ResidenceTypeService {
	@Autowired
    ResidenceTypeRepository residenceTypeRepository;
	

	public ResidenceType addResidenceType(ResidenceType m) {
		return residenceTypeRepository.save(m);
	}

	public void deleteResidenceType(Long id) {
		if (residenceTypeRepository.findById(id).isPresent())
			residenceTypeRepository.deleteById(id);
	}

	public ResidenceType updateResidenceType(ResidenceType p) {
		return residenceTypeRepository.saveAndFlush(p);
	}

	public ResidenceType findResidenceType(Long id) {
		return residenceTypeRepository.findById(id).get();
	}

	public List<ResidenceType> findAll() {
		return residenceTypeRepository.findAll();
	}



}
