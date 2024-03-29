package com.sofrecom.authentifmou3ina.services;
import java.util.List;

import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.entities.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;




public interface Imou3inaService {
	public Mou3inaEntity addMou3ina(Mou3inaEntity m);
	

	public void deleteMou3ina(Long id);

	public Mou3inaEntity  updateMou3ina (Mou3inaEntity m);

	public Mou3inaEntity  findMou3ina (Long id);
	
	public Mou3inaEntity  findMou3inaa (Long id);



	public void deleteByProcessInstanceID(String processInstanceID);


	// Filtrage par propriété
	public Mou3inaEntity findByfirstName(String firstName);

	public Mou3inaEntity  findByTypeService(String serviceType);

	public ResponseEntity<Object> findAll() ;

	public Mou3inaEntity ValidateDoc(Long id);
	public Mou3inaEntity DismissDoc(Long id) ;

	public String CalculSalary(Long id) ;

	//public String costService(Long id );

}
