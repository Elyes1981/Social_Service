package com.sofrecom.authentifmou3ina.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sofrecom.authentifmou3ina.entities.Interview;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.entities.ResponseMessage;
import com.sofrecom.authentifmou3ina.repository.Mou3inaRepository;
import com.sofrecom.authentifmou3ina.services.Imou3inaService;
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
import java.util.List;
import javax.servlet.ServletContext;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class Mou3inaRestController {
	@Autowired
	Imou3inaService mou3inaService;
	@Autowired
	Mou3inaRepository mou3inaRepository;

	@Autowired
	RuntimeService runtimeService;


	//public static final String DIRECTORY =  "C://Users/a.mosbah/Downloads/operation-admin-fe-master/operation-admin-fe-master/src/assets/img";

	@RequestMapping(value = "/Mou3inas" , method = RequestMethod.GET) //RequestMapping
	public ResponseEntity<Object> findMou3iness() {
		return (ResponseEntity<Object>) mou3inaService.findAll();
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
	
	
	
	
	
	@PostMapping(value = "/Mou3ina/newMou3ina")
	public Mou3inaEntity addMou3ina(@RequestBody Mou3inaEntity m) {
		return mou3inaService.addMou3ina(m);

		
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

	/*@PostMapping(value = "/telecharger/{id}" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Transactional
	public ResponseEntity<List<String>> uploadFiles(@PathVariable("id") Long id, @RequestParam("files") List<MultipartFile> multipartFiles) throws IOException, InterruptedException , JsonParseException, JsonMappingException {
		Mou3inaEntity mou3ina =mou3inaService.findMou3ina(id);
		boolean isExist = new File(context.getRealPath("/Images/")).exists();
		if(!isExist)
		{
			new File (context.getRealPath("Images/")).mkdir() ;
		}
		String filename = file.getOriginalFilename();
		String newFileName = FilenameUtils.getBaseName(filename)+"."+FileNameUtils.getExtension(filename);
		File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
		try
		{
			FileUtils.writeByteArrayToFile(serverFile , file.getBytes()) ;
		}catch(Exception e) {
			e.printStackTrace();
		}


		finantrain.setImageTrainer(newFileName) ;
		FinancialTraining ft = financialtrainingrepository.save(finantrain) ;

	}
*/
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

	@PutMapping(value="/CalculSalary/{id}")
	@ResponseBody
	public ResponseMessage CalculSalary(@PathVariable Long id ) {
		String str = "";
		str = mou3inaService.CalculSalary(id);
		ResponseMessage m = new ResponseMessage();
		m.setStr(str);
		return m;
	}



	
}