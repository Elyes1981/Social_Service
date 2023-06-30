package com.sofrecom.operation.customer.service;

import com.sofrecom.operation.customer.entities.Mou3inaEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface Imou3inaService {
	public Mou3inaEntity addMou3ina(Mou3inaEntity m);
	

	public void deleteMou3ina(Long id);

	public Mou3inaEntity  updateMou3ina (Mou3inaEntity m);

	public Mou3inaEntity  findMou3ina (Long id);


	public ResponseEntity<Object> findAll() ;

	public List<Mou3inaEntity> findByServicesTypes(List<String> ids) ;


}
