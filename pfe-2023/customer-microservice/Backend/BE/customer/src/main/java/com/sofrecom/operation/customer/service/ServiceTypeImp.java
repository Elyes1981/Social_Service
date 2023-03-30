package com.sofrecom.operation.customer.service;
import java.util.List;

import com.sofrecom.operation.customer.dao.TypeServiceRepository;
import com.sofrecom.operation.customer.entities.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTypeImp implements IServiceType {
	@Autowired
    TypeServiceRepository typeServiceRepository;
	
	@Override
	public ServiceType addServiceType(ServiceType m) {
		typeServiceRepository.save(m);
		return m;
	}

	@Override
	public void deleteServiceType(Long id) {
		if(typeServiceRepository.findById(id).isPresent())
			typeServiceRepository.deleteById(id);	
		
		
	}

	@Override
	public ServiceType updateServiceType(ServiceType m) {
		return typeServiceRepository.saveAndFlush(m);
	}

	@Override
	public ServiceType findServiceType(Long id) {
		ServiceType m=(ServiceType) typeServiceRepository.findById(id).get();
		  return m;

	}

	@Override
	public List<ServiceType> findAll() {
		return typeServiceRepository.findAll();
	}
	
}
