package com.sofrecom.operation.customer.service;

import java.util.List;

import com.sofrecom.operation.customer.dao.GenderRepository;
import com.sofrecom.operation.customer.entities.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
