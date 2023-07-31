package com.sofrecom.authentifmou3ina.repository;



import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sofrecom.authentifmou3ina.entities.EmploymentStatus;
import com.sofrecom.authentifmou3ina.entities.Interview;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.entities.ServiceType;
import feign.Param;
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


	Integer countByEmploymentStatusAndDeligationName(EmploymentStatus employmentStatus, String delegationName);

	List<Mou3inaEntity> findByEmploymentStatus(EmploymentStatus employmentStatus);
	
	
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

	@Query("SELECT m FROM Mou3inaEntity m WHERE m.employmentStatus = 'salaried_employee'")
	List<Mou3inaEntity> findSalariedEmployees();

	@Query("SELECT m FROM Mou3inaEntity m WHERE m.employmentStatus = 'self_employed'")
	List<Mou3inaEntity> findNonSalariedEmployees();



	/*@Query("SELECT m FROM Mou3inaEntity m WHERE m.company.id = :companyId")
	List<Mou3inaEntity> findByCompanyId(@Param("companyId") Long id);*/


	@Query("SELECT m FROM Mou3inaEntity m " +
			"JOIN m.serviceType st " +
			"JOIN m.Availibility a " +
			"WHERE st IN :serviceTypes " +
			"AND a.date = :desiredDate " +
			"AND (:morning = false OR a.morning = true) " +
			"AND (:evening = false OR a.evening = true) " +
			"AND (:afternoon = false OR a.afternoon = true)")
    List<Mou3inaEntity> findAvailableProviders(@Param("serviceType") Collection<ServiceType> serviceTypes,
                                               @Param("desiredDate") Date desiredDate,
                                               @Param("morning") boolean morning,
                                               @Param("evening") boolean evening,
                                               @Param("afternoon") boolean afternoon);

}
