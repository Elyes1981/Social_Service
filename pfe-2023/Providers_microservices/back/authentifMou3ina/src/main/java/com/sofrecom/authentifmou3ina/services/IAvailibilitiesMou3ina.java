package com.sofrecom.authentifmou3ina.services;



import com.sofrecom.authentifmou3ina.entities.AvailibilitiesMou3ina;

import java.util.List;

public interface IAvailibilitiesMou3ina {
	public AvailibilitiesMou3ina addAvailibilitiesMou3ina(AvailibilitiesMou3ina m);
	public List< AvailibilitiesMou3ina > findAll();
	public List< AvailibilitiesMou3ina > findMorning();
	public AvailibilitiesMou3ina updateAvailibilitiesMou3ina(AvailibilitiesMou3ina p);
	List<Float> findWeekndByMou3ina(Long id, int year);
}
