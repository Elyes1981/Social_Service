package com.sofrecom.operation.admin.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.sofrecom.operation.admin.entities.Mou3inaEntity;


public interface Imou3inaService {
	public Mou3inaEntity addMou3ina(Mou3inaEntity m);
	

	public void deleteMou3ina(Long id);

	public Mou3inaEntity  updateMou3ina (Mou3inaEntity m);

	public Mou3inaEntity  findMou3ina (Long id);


	public ResponseEntity<Object> findAll() ;


}
