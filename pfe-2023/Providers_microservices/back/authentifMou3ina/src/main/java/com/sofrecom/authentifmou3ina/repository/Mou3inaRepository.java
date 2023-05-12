package com.sofrecom.authentifmou3ina.repository;



import java.util.Optional;

import com.sofrecom.authentifmou3ina.entities.Interview;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;





import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface Mou3inaRepository extends JpaRepository<Mou3inaEntity, Long> {
	Mou3inaEntity findByFirstName(String firstName);
	Mou3inaEntity findByServiceType(String serviceType);
	
	
	@Modifying
	@Query("update Mou3inaEntity m set m.photo =:logoPath where m.id =:idMouina")
	public void updateLogoPath( long idMouina, String logoPath);

	
	@Modifying
	@Query("update Mou3inaEntity m set m.name =:logoPath where m.id =:idMouina")
	public void updateLogoPath2( long idMouina, String logoPath);
	
	Optional<Mou3inaEntity> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByemailAdress(String emailAdress);

	@Modifying
	@Transactional
	@Query("delete from Mou3inaEntity m  where m.processInstanceID =:processInstanceID")
	void deleteByProcessInstanceID(String processInstanceID);

	Mou3inaEntity findByProcessInstanceID(String processInstanceID);






}
