package com.sofrecom.authentifmou3ina.services;
import java.util.List;

import com.sofrecom.authentifmou3ina.entities.CooptedByType;
import com.sofrecom.authentifmou3ina.repository.CooptedByTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CooptedByTypeServiceImpl implements CooptedByTypeService {
	@Autowired
	CooptedByTypeRepository cooptedByTypeRepository;

	public CooptedByType addCooptedByType(CooptedByType m) {
		return cooptedByTypeRepository.save(m);
	}

	public void deleteCooptedByType(Long id) {
		if (cooptedByTypeRepository.findById(id).isPresent())
			cooptedByTypeRepository.deleteById(id);
	}

	public CooptedByType updateCooptedByType(CooptedByType p) {
		return cooptedByTypeRepository.saveAndFlush(p);
	}
	
	public CooptedByType findCooptedByType(Long id) {
		return cooptedByTypeRepository.findById(id).get();
	}

	public List<CooptedByType> findAll() {
		return cooptedByTypeRepository.findAll();
	}
	
	
	
	
	
}
