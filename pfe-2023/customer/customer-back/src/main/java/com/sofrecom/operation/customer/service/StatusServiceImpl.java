package com.sofrecom.operation.customer.service;

import java.util.List;

import com.sofrecom.operation.customer.dao.StatusRepository;
import com.sofrecom.operation.customer.entities.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StatusServiceImpl implements StatusService {
	@Autowired
    StatusRepository statusRepositroy;
	

	public Status addStatus(Status m) {
		return statusRepositroy.save(m);
	}

	public void deleteStatus(Long id) {
		if (statusRepositroy.findById(id).isPresent())
			statusRepositroy.deleteById(id);
	}

	public Status updateStatus(Status p) {
		return statusRepositroy.saveAndFlush(p);
	}

	public Status findStatus(Long id) {
		return statusRepositroy.findById(id).get();
	}

	public List<Status> findAll() {
		return statusRepositroy.findAll();
	}



}
