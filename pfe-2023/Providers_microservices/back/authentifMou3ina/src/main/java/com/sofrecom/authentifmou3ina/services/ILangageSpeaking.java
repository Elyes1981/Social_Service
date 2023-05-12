package com.sofrecom.authentifmou3ina.services;
import com.sofrecom.authentifmou3ina.entities.LangageSpeaking;

import java.util.List;




public interface ILangageSpeaking {
	public LangageSpeaking addLangageSpeaking(LangageSpeaking m);

	public void deleteLangageSpeaking(Long id);

	public LangageSpeaking  updateLangageSpeaking (LangageSpeaking m);

	public LangageSpeaking  findLangageSpeaking (Long id);
	

	


	
	
	public List<LangageSpeaking> findAll();


}
