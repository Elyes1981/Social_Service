package com.sofrecom.authentifmou3ina.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sofrecom.authentifmou3ina.entities.*;
import com.sofrecom.authentifmou3ina.repository.Mou3inaRepository;
import com.sofrecom.authentifmou3ina.repository.NotificationRepository;
import com.sofrecom.authentifmou3ina.services.FirebaseMessagingMobile;
import com.sofrecom.authentifmou3ina.services.Imou3inaService;
import com.sofrecom.authentifmou3ina.util.FeignServiceUtil;
import org.apache.commons.io.FilenameUtils;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletContext;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class Mou3inaRestController {
	@Autowired
	Imou3inaService mou3inaService;
	@Autowired
	Mou3inaRepository mou3inaRepository;

	@Autowired
	private FirebaseMessagingMobile firebaseServiceMobile;

	@Autowired
	NotificationRepository notificationRepository ;


	@Autowired
	RuntimeService runtimeService;

	@Autowired
	FeignServiceUtil feignServiceUtil;


	//public static final String DIRECTORY =  "C://Users/a.mosbah/Downloads/operation-admin-fe-master/operation-admin-fe-master/src/assets/img";

	@RequestMapping(value = "/Mou3inas" , method = RequestMethod.GET) //RequestMapping
	public ResponseEntity<Object> findMou3iness() {
		return  mou3inaService.findAll();
	}


	@GetMapping("/countProviders/{delegationName}")
	public ResponseEntity<Integer> countSelfEmployedInDelegation(@PathVariable String delegationName) {
		int count = mou3inaRepository.countByEmploymentStatusAndDeligationName(EmploymentStatus.self_employed,delegationName);
		return ResponseEntity.ok(count);
	}

	@GetMapping("/occupation-rate/{mou3inaId}")
	public ResponseEntity<Double> getOccupationRate(@PathVariable Long mou3inaId) {
		double occupationRate = mou3inaService.calculateOccupationRate(mou3inaId);
		return ResponseEntity.ok(occupationRate);
	}

	@GetMapping("/average-occupation-rate")
	public ResponseEntity<Double> getAverageOccupationRate() {
		double averageOccupationRate = mou3inaService.calculateAverageOccupationRate();
		return ResponseEntity.ok(averageOccupationRate);
	}

	@PutMapping("/AddOrder/{id}")
	public ResponseEntity<String> incrementServicesDone(@PathVariable Long id) throws Exception {
		Optional<Mou3inaEntity> mou3inaOptional = mou3inaRepository.findById(id);
		if (mou3inaOptional.isPresent()) {
			Mou3inaEntity mou3ina = mou3inaOptional.get();

			// Vérifier si la réinitialisation hebdomadaire est nécessaire
			if (LocalDate.now().getDayOfWeek() == DayOfWeek.SUNDAY) {
				mou3inaService.resetServicesDone(); // Réinitialiser les services effectués chaque dimanche à minuit
			}

			Integer servicesDone = mou3ina.getServicesDone();
			if (servicesDone == null) {
				servicesDone = 0;
			}
			mou3ina.setServicesDone(servicesDone + 1);
			firebaseServiceMobile.sendNotificationToProvider("Task", "New cleaning task has been assigned to you ", "eGNkaJYYSmaGPJ-kYdU3Ak:APA91bFAVyacW2BSTJLsnkPCvVXPlJmMNcaV6ukOZhg5a1p5tk9UMYqYjf0mEAapraY3blleqhQFM4jb8iuwaZ5m9nxauTA7OK0YcLK61cYTAZR2pshuWQede68JncD7o2OlB9z3YPrb", mou3ina , null);
			mou3inaRepository.save(mou3ina);
			return ResponseEntity.ok("order added successfully to provider");
		} else {
			return ResponseEntity.notFound().build();
		}
	}


	@GetMapping(value = "/Mou3ina/{id}")
	public Mou3inaEntity findOneMou3inaById(@PathVariable Long id) {
		
		return	 mou3inaService.findMou3ina(id);
	}


	@GetMapping(value = "/Mou3inaa/{id}")
	public Mou3inaEntity findOneMou3ina(@PathVariable Long id) {
		
		return	 mou3inaService.findMou3inaa(id);
	
		
		 
	}	
	@GetMapping(value = "/Mou3ina/Search/firstName")
	public Mou3inaEntity findMou3inanByfirstName(@PathVariable String e) {
		return mou3inaService.findByfirstName(e);
	}


	@PutMapping("/commission")
	public ResponseEntity<String> updateCommissionPercentageForAllProviders(@RequestParam("percentage") double commissionPercentage) {
		mou3inaService.updateCommissionPercentageForAllProviders(commissionPercentage);
		return ResponseEntity.ok("Percentage of commission updated for all providers.");
	}
	
	
	@PostMapping(value = "/Mou3ina/newMou3ina")
	public Mou3inaEntity addMou3ina(@RequestBody Mou3inaEntity m) {
		Mou3inaEntity mou3ina = mou3inaService.addMou3ina(m);
		feignServiceUtil.insertProvidersFromOtherMicroservice();
		return mou3ina;

		
	}
	
	@PutMapping(value = "/Mou3inas/Mou3ina/{id}")
	public Mou3inaEntity updateMou3ina(@PathVariable Long id, @RequestBody Mou3inaEntity p) {
		p.setId(id);
		return mou3inaService.updateMou3ina(p);
	}

	@DeleteMapping(value = "/deleteMou3inas/{id}")
	public void deleteMou3ina(@PathVariable Long id) {
		mou3inaService.deleteMou3ina(id);
	}


	@PutMapping(value="/ValidateDoc/{id}")
	@ResponseBody
	public Mou3inaEntity ValidateDoc(@PathVariable Long id){
		Mou3inaEntity mou3ina=mou3inaService.ValidateDoc(id);
		return mou3ina ;
	}

	@PutMapping(value="/DismissDoc/{id}")
	@ResponseBody
	public Mou3inaEntity DismissDoc(@PathVariable Long id){
		Mou3inaEntity mou3ina =mou3inaService.DismissDoc(id);
		return mou3ina ;
	}



	@GetMapping("/companyPercentage/{providerId}")
	public double getCompanyPercentageByProviderId(@PathVariable Long providerId) {
		return mou3inaService.getCompanyPercentageById(providerId);
	}


















}