package com.sofrecom.authentifmou3ina.controller;

import java.util.List;

import com.sofrecom.authentifmou3ina.entities.LangageSpeaking;
import com.sofrecom.authentifmou3ina.services.ILangageSpeaking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin
@RestController
public class LangageSpeakingRestController {
	@Autowired
	ILangageSpeaking iLangageSpeaking;
	@GetMapping("/LangageSpeaking")
	public List<LangageSpeaking> findLangageSpeaking() {
		return iLangageSpeaking.findAll();
	}
	@GetMapping(value = "/LangageSpeaking/{id}")
	public LangageSpeaking findOneLangageSpeakingById(@PathVariable Long id) {
		return iLangageSpeaking.findLangageSpeaking(id);
	}	
	
	@PostMapping(value = "/LangageSpeaking/newLangageSpeaking")
	public LangageSpeaking addLangageSpeaking(@RequestBody LangageSpeaking m) {
		return iLangageSpeaking.addLangageSpeaking(m);
	}

	@PutMapping(value = "/LangageSpeaking/langage/{id}")
	public LangageSpeaking updateLangageSpeaking(@PathVariable Long id, @RequestBody LangageSpeaking p) {
		p.setIdLangageSpeaking(id);
		return iLangageSpeaking.updateLangageSpeaking(p);
	}

	@DeleteMapping(value = "/deleteLangageSpeaking/{id}")
	public void deleteLangageSpeaking(@PathVariable Long id) {
		iLangageSpeaking.deleteLangageSpeaking(id);
	}
	
	
}
