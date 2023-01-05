package com.sofrecom.operation.admin.service;

import java.util.List;

import com.sofrecom.operation.admin.entities.ServiceType;

public interface IServiceType {
	public ServiceType addServiceType(ServiceType m);

	public void deleteServiceType(Long id);

	public ServiceType  updateServiceType (ServiceType m);

	public ServiceType  findServiceType (Long id);
	

	


	
	
	public List<ServiceType> findAll();

}
