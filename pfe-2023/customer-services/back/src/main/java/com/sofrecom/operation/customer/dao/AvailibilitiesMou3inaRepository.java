package com.sofrecom.operation.customer.dao;

import com.sofrecom.operation.customer.entities.AvailibilitiesMou3ina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

//@Repository
public interface AvailibilitiesMou3inaRepository extends JpaRepository<AvailibilitiesMou3ina, Long> {

	@Query("SELECT u FROM AvailibilitiesMou3ina u WHERE u.Mou3inaEntity.id =:e and u.morning=true ")
	List<AvailibilitiesMou3ina> findByMou3inaEntityByMorning(long e);

	@Query("SELECT u FROM AvailibilitiesMou3ina u WHERE u.Mou3inaEntity.id =:e and u.evening = true")
	List<AvailibilitiesMou3ina> findByMou3inaEntityByEvening(long e);
	@Query("SELECT u FROM AvailibilitiesMou3ina u WHERE u.Mou3inaEntity.id =:e and u.afternoon = true")
	List<AvailibilitiesMou3ina> findByMou3inaEntityByAfternoon(long e);
	@Query("SELECT u FROM AvailibilitiesMou3ina u  WHERE u.Mou3inaEntity.id=:e and EXTRACT(YEAR FROM u.date) =:year")
    List<AvailibilitiesMou3ina> findByMou3inaEntityYear(Long e, Integer year);
	
	@Query(value = "SELECT u FROM AvailibilitiesMou3ina u WHERE u.Mou3inaEntity.id =:e and u.date=:d")
	List<AvailibilitiesMou3ina>  findByMou3inaEntityAndDate(long e, LocalDate d);

}