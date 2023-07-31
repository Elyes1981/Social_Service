package com.sofrecom.authentifmou3ina.repository;

import com.sofrecom.authentifmou3ina.entities.LangageSpeaking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface LangageSpeakingRepository extends JpaRepository<LangageSpeaking, Long> {

}
