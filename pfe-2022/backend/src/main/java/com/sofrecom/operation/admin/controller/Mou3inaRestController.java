package com.sofrecom.operation.admin.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.sofrecom.operation.admin.dao.Mou3inaRepository;
import com.sofrecom.operation.admin.entities.Mou3inaEntity;
import com.sofrecom.operation.admin.entities.ServiceType;
import com.sofrecom.operation.admin.service.Imou3inaService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class Mou3inaRestController {
	@Autowired
	Imou3inaService mou3inaService;
	@Autowired Mou3inaRepository mou3inaRepository;
	public static final String DIRECTORY =  "C://Users/a.mosbah/Downloads/operation-admin-fe-master/operation-admin-fe-master/src/assets/img";

	@GetMapping(value = "/Mou3inas")
	public ResponseEntity<Object> findMou3iness() {
		return (ResponseEntity<Object>) mou3inaService.findAll();
	}


	@GetMapping(value = "/Mou3ina/{id}")
	public Mou3inaEntity findOneMou3inaById(@PathVariable Long id) {
		return mou3inaService.findMou3ina(id);
	}

	@PutMapping(value = "/Mou3inas/Mou3ina/{id}")
	public Mou3inaEntity updateMou3ina(@PathVariable Long id, @RequestBody Mou3inaEntity p) {
		p.setId(id);
		return mou3inaService.updateMou3ina(p);
	}

	@PostMapping(value = "/Mou3ina/newMou3ina")
	public Mou3inaEntity addMou3ina(@RequestBody Mou3inaEntity m) {
		return mou3inaService.addMou3ina(m);
	}
	


	@DeleteMapping(value = "/deleteMou3inas/{id}")
	public void deleteMou3ina(@PathVariable Long id) {
		mou3inaService.deleteMou3ina(id);
	}



}
