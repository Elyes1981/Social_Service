package com.sofrecom.authentifmou3ina.services;

import java.util.List;

import com.sofrecom.authentifmou3ina.entities.Seniority;
import com.sofrecom.authentifmou3ina.repository.SeniorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeniorityImp implements ISeniorityService{
	@Autowired
	SeniorityRepository seniorityRepository;

	@Override
	public Seniority addseniority(Seniority m) {

		return  seniorityRepository.save(m);
	}

	@Override
	public void deleteseniority(Long id) {
		if(seniorityRepository.findById(id).isPresent())
			seniorityRepository.deleteById(id);
		
	}

	@Override
	public Seniority updateseniority(Seniority m) {

		return seniorityRepository.saveAndFlush(m);
	}

	@Override
	public Seniority findseniority(Long id) {
		Seniority m=(Seniority) seniorityRepository.findById(id).get();
		  return m;
	}

	@Override
	public List<Seniority> findAll() {
		return seniorityRepository.findAll();
	}
}
