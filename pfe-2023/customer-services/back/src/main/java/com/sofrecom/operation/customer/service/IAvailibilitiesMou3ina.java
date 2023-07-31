package com.sofrecom.operation.customer.service;

import com.sofrecom.operation.customer.entities.AvailibilitiesMou3ina;

import java.util.List;

public interface IAvailibilitiesMou3ina {
	public AvailibilitiesMou3ina addAvailibilitiesMou3ina(AvailibilitiesMou3ina m);
	public List<AvailibilitiesMou3ina > findAll();
	public List< AvailibilitiesMou3ina > findMorning();
	List<Float> findWeekndByMou3ina(Long id, Integer year);

}
