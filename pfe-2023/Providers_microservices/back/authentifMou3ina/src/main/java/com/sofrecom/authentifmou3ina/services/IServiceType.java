package com.sofrecom.authentifmou3ina.services;
import com.sofrecom.authentifmou3ina.entities.ServiceType;

import java.util.List;



public interface IServiceType {
	public ServiceType addServiceType(ServiceType m);

	public void deleteServiceType(Long id);

	public ServiceType  updateServiceType (ServiceType m);

	public ServiceType  findServiceType (Long id);
	

	


	
	
	public List<ServiceType> findAll();

}
