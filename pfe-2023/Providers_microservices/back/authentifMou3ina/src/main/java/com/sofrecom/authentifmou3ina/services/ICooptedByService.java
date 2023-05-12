package com.sofrecom.authentifmou3ina.services;
import com.sofrecom.authentifmou3ina.entities.CooptedBy;

import java.util.List;


public interface ICooptedByService {

	public CooptedBy addcooptedBy(CooptedBy m);

	public void deletecooptedBy(Long id);

	public CooptedBy  updatecooptedBy (CooptedBy m);

	public CooptedBy  findcooptedBy (Long id);

	public List<CooptedBy> findAll();
}
