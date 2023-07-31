package com.sofrecom.authentifmou3ina.controller;

import java.util.List;

import com.sofrecom.authentifmou3ina.entities.ServiceType;
import com.sofrecom.authentifmou3ina.services.IServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;





@CrossOrigin("*")
@RestController
public class TypeServiceRestController {
	@Autowired
	IServiceType iServiceType;

	@GetMapping("/ServiceTypes")
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
