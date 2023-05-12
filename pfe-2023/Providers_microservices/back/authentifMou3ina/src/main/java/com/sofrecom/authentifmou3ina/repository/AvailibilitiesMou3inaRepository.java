package com.sofrecom.authentifmou3ina.repository;

import com.sofrecom.authentifmou3ina.entities.AvailibilitiesMou3ina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AvailibilitiesMou3inaRepository extends JpaRepository<AvailibilitiesMou3ina, Long> {

	@Query("SELECT u FROM AvailibilitiesMou3ina u WHERE u.Mou3inaEntity.id =:e and u.morning=true ")
	List<AvailibilitiesMou3ina> findByMou3inaEntityByMorning(long e);

	@Query("SELECT u FROM AvailibilitiesMou3ina u WHERE u.Mou3inaEntity.id =:e and u.evening = true")
	List<AvailibilitiesMou3ina> findByMou3inaEntityByEvening(long e);
	@Query("SELECT u FROM AvailibilitiesMou3ina u WHERE u.Mou3inaEntity.id =:e and u.afternoon = true")
	List<AvailibilitiesMou3ina> findByMou3inaEntityByAfternoon(long e);
	@Query(value = "SELECT * FROM availibilities_mou3ina u  where u.mou3ina_entity_id=:e and EXTRACT(YEAR FROM u.date) =:year", nativeQuery = true)
	List<AvailibilitiesMou3ina> findByMou3inaEntityYear(long e, long year);
	
	@Query(value = "SELECT u FROM AvailibilitiesMou3ina u WHERE u.Mou3inaEntity.id =:e and u.date=:d")
	List<AvailibilitiesMou3ina>  findByMou3inaEntityAndDate(long e, LocalDate d);

}