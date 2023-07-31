package com.sofrecom.authentifmou3ina.services;
import java.util.List;

import com.sofrecom.authentifmou3ina.entities.Gender;
import com.sofrecom.authentifmou3ina.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class genderImp  implements IGender{
	@Autowired
	GenderRepository genderRepository;

	@Override
	public Gender addGender(Gender m) {
		return  genderRepository.save(m);
	}

	@Override
	public void deleteGender(Long id) {
		if(genderRepository.findById(id).isPresent())
			genderRepository.deleteById(id);
		
	}

	@Override
	public Gender updateGender(Gender m) {
		return genderRepository.saveAndFlush(m);
	}

	@Override
	public Gender findGender(Long id) {
		Gender m=(Gender) genderRepository.findById(id).get();
		  return m;
	}

	@Override
	public List<Gender> findAll() {
		return genderRepository.findAll();
	}

}
