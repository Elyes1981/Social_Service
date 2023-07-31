package com.sofrecom.operation.admin.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofrecom.operation.admin.dao.GouvernoratRepository;
import com.sofrecom.operation.admin.entities.Gouvernorat;


@Service
public class GouvernoratServiceImpl implements GouvernoratService {
	@Autowired
	GouvernoratRepository gouvernoratRepository;
	

	public Gouvernorat addGouvernorat(Gouvernorat m) {
		return gouvernoratRepository.save(m);
	}

	public void deleteGouvernorat(Long id) {
		if (gouvernoratRepository.findById(id).isPresent())
			gouvernoratRepository.deleteById(id);
	}

	public Gouvernorat updateGouvernorat(Gouvernorat p) {
		return gouvernoratRepository.saveAndFlush(p);
	}

	public Gouvernorat findGouvernorat(Long id) {
		return gouvernoratRepository.findById(id).get();
	}

	public List<Gouvernorat> findAll() {
		return gouvernoratRepository.findAll();
	}
	/*@Override
	public Collection<Delegation> findDelegationByGouvernorat(Long idgouv) {
		
		Gouvernorat gvr=gouvernoratRepository.findById(idgouv).get();

		return delegationRepository.findByGouvernorat(gvr);
	}*/


}
