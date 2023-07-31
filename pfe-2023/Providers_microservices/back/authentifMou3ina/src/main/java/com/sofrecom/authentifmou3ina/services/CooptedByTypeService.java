package com.sofrecom.authentifmou3ina.services;
import java.util.List;

import com.sofrecom.authentifmou3ina.entities.CooptedByType;
import org.springframework.beans.factory.annotation.Autowired;



public interface CooptedByTypeService {
	
		

	public CooptedByType addCooptedByType(CooptedByType m);

	public void deleteCooptedByType(Long id);

	public CooptedByType updateCooptedByType(CooptedByType p);

	public CooptedByType findCooptedByType(Long id);

	public List<CooptedByType> findAll();

}
