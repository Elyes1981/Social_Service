package com.sofrecom.operation.customer.controller;

import com.sofrecom.operation.customer.entities.ServiceType;
import com.sofrecom.operation.customer.service.IServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TypeServiceRestController {
	@Autowired
	IServiceType iServiceType;

	@RequestMapping(value = "/ServiceTypes", method = RequestMethod.GET)
	public List<ServiceType> findServiceTypes() {
		return iServiceType.findAll();
	}
	@GetMapping(value = "/ServiceType/{id}")
	public ServiceType findOneServiceTypeById(@PathVariable Long id) {
		return iServiceType.findServiceType(id);
	}
	@PostMapping(value = "/ServiceType/newServiceType")
	public ServiceType addServiceType(@RequestBody ServiceType m) {
		return iServiceType.addServiceType(m);
	}
	@PutMapping(value = "/ServiceTypes/ServiceType/{id}")
	public ServiceType updateServiceType(@PathVariable Long id, @RequestBody ServiceType p) {
		p.setIdService(id);
		return iServiceType.updateServiceType(p);
	}

	@DeleteMapping(value = "/deleteServiceTypes/{id}")
	public void deleteServiceType(@PathVariable Long id) {
		iServiceType.deleteServiceType(id);
	}


	


}
