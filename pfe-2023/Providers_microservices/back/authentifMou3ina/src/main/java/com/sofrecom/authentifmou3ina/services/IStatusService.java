package com.sofrecom.authentifmou3ina.services;
import com.sofrecom.authentifmou3ina.entities.Status;

import java.util.List;




public interface IStatusService {
	public Status addStatus(Status m);

	public void deleteStatus(Long id);

	public Status  updateStatus (Status m);

	public Status  findStatus (Long id);
	

	


	
	
	public List<Status> findAll();

}

