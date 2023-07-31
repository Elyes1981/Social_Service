package com.sofrecom.authentifmou3ina.services;
import java.util.List;

import com.sofrecom.authentifmou3ina.entities.Status;
import com.sofrecom.authentifmou3ina.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StatusImp  implements IStatusService{
	@Autowired
	StatusRepository statusRepository;

	@Override
	public Status addStatus(Status m) {

		return  statusRepository.save(m);
	}

	@Override
	public void deleteStatus(Long id) {
		if(statusRepository.findById(id).isPresent())
			statusRepository.deleteById(id);
	}

	@Override
	public Status updateStatus(Status m) {
		return statusRepository.saveAndFlush(m);
	}

	@Override
	public Status findStatus(Long id) {
		Status m=(Status) statusRepository.findById(id).get();
		  return m;
	}

	@Override
	public List<Status> findAll() {
		return statusRepository.findAll();
	}


}
