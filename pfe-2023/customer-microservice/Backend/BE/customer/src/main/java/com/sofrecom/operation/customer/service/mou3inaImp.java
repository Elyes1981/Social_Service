package com.sofrecom.operation.customer.service;

import com.sofrecom.operation.customer.dao.Mou3inaRepository;
import com.sofrecom.operation.customer.entities.Mou3inaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class mou3inaImp  implements Imou3inaService{
	@Autowired
	Mou3inaRepository mou3inaRepository;
	

	@Override
	public void deleteMou3ina(Long id) {
		if(mou3inaRepository.findById(id).isPresent())
			mou3inaRepository.deleteById(id);	
		
	}

	@Override
	public Mou3inaEntity updateMou3ina(Mou3inaEntity m) {
		return mou3inaRepository.saveAndFlush(m);
	
	}

	@Override
	public Mou3inaEntity findMou3ina(Long id) {
		Mou3inaEntity m=(Mou3inaEntity) mou3inaRepository.findById(id).get();
	  return m;
	}

	@Override
	public ResponseEntity<Object> findAll() {
        List<Mou3inaEntity> dbMou3inas = mou3inaRepository.findAll();
        if (dbMou3inas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
       
				 return new ResponseEntity<>(dbMou3inas, HttpStatus.OK);
			}
        	

	@Override
	public Mou3inaEntity addMou3ina(Mou3inaEntity m) {
		
		return  mou3inaRepository.save(m);
	}



	
	



}

	

	


	
	


