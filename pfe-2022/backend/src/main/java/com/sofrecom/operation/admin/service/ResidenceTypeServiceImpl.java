package com.sofrecom.operation.admin.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofrecom.operation.admin.dao.ResidenceTypeRepository;

import com.sofrecom.operation.admin.entities.ResidenceType;


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
