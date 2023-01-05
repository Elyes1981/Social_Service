package com.sofrecom.operation.admin.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofrecom.operation.admin.dao.GenderRepository;
import com.sofrecom.operation.admin.entities.Gender;




@Service
public class GenderServiceImpl implements GenderService {
	@Autowired
	GenderRepository genderRepository;
	

	public Gender addGender(Gender m) {
		return genderRepository.save(m);
	}

	public void deleteGender(Long id) {
		if (genderRepository.findById(id).isPresent())
			genderRepository.deleteById(id);
	}

	public Gender updateGender(Gender p) {
		return genderRepository.saveAndFlush(p);
	}

	public Gender findGender(Long id) {
		return genderRepository.findById(id).get();
	}

	public List<Gender> findAll() {
		return genderRepository.findAll();
	}



}
