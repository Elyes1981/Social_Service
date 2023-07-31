package com.sofrecom.operation.customer.controller;

import com.sofrecom.operation.customer.dao.AvailibilitiesMou3inaRepository;
import com.sofrecom.operation.customer.dao.Mou3inaRepository;
import com.sofrecom.operation.customer.entities.AvailibilitiesMou3ina;
import com.sofrecom.operation.customer.entities.Mou3inaEntity;
import com.sofrecom.operation.customer.service.IAvailibilitiesMou3ina;
import com.sofrecom.operation.customer.service.Imou3inaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/test")
public class AvailibilitiesMou3inaController {
	@Autowired
	IAvailibilitiesMou3ina AvailibilitiesMou3inaservice;

	@Autowired
	Mou3inaRepository mou3inaRepository ;

	@Autowired
	AvailibilitiesMou3inaRepository AvailibilitiesMou3inaRepository;
	@Autowired
	Imou3inaService mou3inaService;

	@PostMapping(value = "/disponibilite/{id}")
	public AvailibilitiesMou3ina addAvailibilitiesMou3ina(@PathVariable Long id, @RequestBody AvailibilitiesMou3ina m) {
		Mou3inaEntity mouina=(Mou3inaEntity) mou3inaRepository.findById(id).get();
		m.setMou3inaEntity(mouina);
		AvailibilitiesMou3ina availibilitiesMou3ina = AvailibilitiesMou3inaservice.addAvailibilitiesMou3ina(m);
		return availibilitiesMou3ina;
	}

	@RequestMapping(value = "/availibilities/{id}/{year}", method =RequestMethod.GET)
	public List<Float>findWeekendByMou3inaYear(@PathVariable Long id,@PathVariable Integer year)
	{
		//iWeekendService.findWeekndByMou3ina(id,year);
		return AvailibilitiesMou3inaservice.findWeekndByMou3ina(id,year);
	}


	@RequestMapping(value = "/availibilitiesMou3ina", method = RequestMethod.GET)
	public List<AvailibilitiesMou3ina> findAvailibilitiesMou3ina() {
		return AvailibilitiesMou3inaservice.findAll();
	}
	/*@RequestMapping(value = "/availibilities/{id}/{year}", method =RequestMethod.GET)
	public List<Float>findWeekendByMou3inaYear(@PathVariable Long id,@PathVariable int year)
	{
		 //iWeekendService.findWeekndByMou3ina(id,year);
		return AvailibilitiesMou3inaservice.findWeekndByMou3ina(id,year);
			}


	@RequestMapping(value = "/availibilitiesMou3inaMorning/{id}", method = RequestMethod.GET)
	public List<AvailibilitiesMou3ina> findAvailibilitiesMou3inaMorning(@PathVariable Long id){
		return AvailibilitiesMou3inaRepository.findByMou3inaEntityByMorning(id);
	}
	@RequestMapping(value = "/availibilitiesMou3inaAfternoon/{id}", method = RequestMethod.GET)
	public List<AvailibilitiesMou3ina> findAvailibilitiesMou3inaAfternoon(@PathVariable Long id) {
		return AvailibilitiesMou3inaRepository.findByMou3inaEntityByAfternoon(id);
	}
	@RequestMapping(value = "/availibilitiesMou3inaEvening/{id}", method = RequestMethod.GET)
	public List<AvailibilitiesMou3ina> findAvailibilitiesMou3inaEvening(@PathVariable Long id) {
		return AvailibilitiesMou3inaRepository.findByMou3inaEntityByEvening(id);
	}
	@PostMapping("availibilities-by-day/{id}")
	public List<AvailibilitiesMou3ina> findAvailibilitiesByDay(@PathVariable Long id,@RequestBody LocalDate d) {
		return AvailibilitiesMou3inaRepository.findByMou3inaEntityAndDate(id,d);
	}
	*/
}
