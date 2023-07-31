package com.sofrecom.operation.customer.controller;

import com.sofrecom.operation.customer.entities.Gender;
import com.sofrecom.operation.customer.service.GenderService;
import com.sofrecom.operation.customer.util.FeignServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gender")
@CrossOrigin(origins = "http://localhost:4200")
public class GenderController {
	@Autowired
    GenderService genderService;

	@Autowired
	 FeignServiceUtil feignServiceUtil ;
	@GetMapping(value ="/find")
	public String hello(){
		return "test";
	}
	@GetMapping(value = "/genders")
	public List<Gender> findAllgender() {
		return genderService.findAll() ;
	}

	@GetMapping(value = "/genders/{id}")
	public Gender findoneGender(@PathVariable Long id) {
		return genderService.findGender(id);
	}

	@PostMapping(value ="/genders")
	public Gender addGender(@RequestBody Gender m) {
		return genderService.addGender(m);
	}

	
	@PutMapping(value ="/genders/{id}")
	public Gender updateGender(@PathVariable Long id, @RequestBody Gender p) {
	p.setId(id);
		return genderService.updateGender(p);
		
	}

	@DeleteMapping(value = "/genders/{id}")
	public void deleteGender(@PathVariable Long id) {
		genderService.deleteGender(id);
	}

	@GetMapping(value = "/hello")
	public String findMou3iness(){
		return feignServiceUtil.hello();

	}



}
