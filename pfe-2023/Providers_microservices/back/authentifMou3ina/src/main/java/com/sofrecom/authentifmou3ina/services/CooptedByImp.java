package com.sofrecom.authentifmou3ina.services;

import java.util.List;

import com.sofrecom.authentifmou3ina.entities.CooptedBy;
import com.sofrecom.authentifmou3ina.repository.CooptedByRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CooptedByImp implements ICooptedByService{
	@Autowired
	CooptedByRepository cooptedByRepository;
	@Override
	public CooptedBy addcooptedBy(CooptedBy m) {
		return  cooptedByRepository.save(m);
	}

	@Override
	public void deletecooptedBy(Long id) {
		if(cooptedByRepository.findById(id).isPresent())
			cooptedByRepository.deleteById(id);	
	}

	@Override
	public CooptedBy updatecooptedBy(CooptedBy m) {
		return cooptedByRepository.saveAndFlush(m);
	}

	@Override
	public CooptedBy findcooptedBy(Long id) {
		CooptedBy m=(CooptedBy) cooptedByRepository.findById(id).get();
		  return m;
	}

	@Override
	public List<CooptedBy> findAll() {
		return cooptedByRepository.findAll();
	}

}
