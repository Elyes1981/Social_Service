package com.sofrecom.authentifmou3ina.services;
import java.util.List;

import com.sofrecom.authentifmou3ina.entities.LangageSpeaking;
import com.sofrecom.authentifmou3ina.repository.LangageSpeakingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class LangageSpeakingImp  implements ILangageSpeaking{
	@Autowired
	LangageSpeakingRepository langageSpeakingRepository;
	@Override
	public LangageSpeaking addLangageSpeaking(LangageSpeaking m) {
		langageSpeakingRepository.save(m);
		return m;
	}

	@Override
	public void deleteLangageSpeaking(Long id) {
		if(langageSpeakingRepository.findById(id).isPresent())
			langageSpeakingRepository.deleteById(id);
		
	}

	@Override
	public LangageSpeaking updateLangageSpeaking(LangageSpeaking m) {
		return langageSpeakingRepository.saveAndFlush(m);
	}

	@Override
	public LangageSpeaking findLangageSpeaking(Long id) {
		LangageSpeaking m=(LangageSpeaking) langageSpeakingRepository.findById(id).get();
		  return m;
	}

	@Override
	public List<LangageSpeaking> findAll() {
		return langageSpeakingRepository.findAll();
		
	}

}
