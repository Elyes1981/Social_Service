package com.sofrecom.operation.customer.dao;
import com.sofrecom.operation.customer.entities.Delegation;
import com.sofrecom.operation.customer.entities.Gouvernorat;
import com.sofrecom.operation.customer.entities.Mou3inaEntity;
import com.sofrecom.operation.customer.entities.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Collection;
import java.util.Date;
import java.util.List;

//@Repository
public interface Mou3inaRepository extends JpaRepository<Mou3inaEntity, Long> {


    /*la requête récupère les fournisseurs (Mou3inaEntity) qui sont disponibles pour les types de services spécifiés (serviceTypes), à la date souhaitée (desiredDate),
    et pendant les périodes de la journée spécifiées (matin, soir, après-midi).*/
/*@Query("SELECT m FROM Mou3inaEntity m JOIN m.serviceType st JOIN AvailibilitiesMou3ina a ON m.id = a.Mou3inaEntity.id " +
        "WHERE st IN :serviceTypes " +
        //"AND a.date = :desiredDate" +
        " AND a.morning = :morning " +
        "AND a.evening = :evening " +
        "AND a.afternoon = :afternoon")*/

/*    @Query("SELECT m FROM Mou3inaEntity m JOIN AvailibilitiesMou3ina a ON m.id = a.Mou3inaEntity.id  " +
            "WHERE a.date = :desiredDate " +
            "AND a.morning = :morning " +
            "AND a.evening = :evening " +
            "AND a.afternoon = :afternoon")*/
@Query("SELECT DISTINCT m FROM Mou3inaEntity m " +
        "JOIN AvailibilitiesMou3ina a ON m.id = a.Mou3inaEntity.id " +
        "JOIN m.serviceType st " +
        "WHERE a.date = :desiredDate " +
        "AND ((:morning = true AND :afternoon = false AND :evening = false AND a.morning = true) " +
        "OR (:morning = false AND :afternoon = true AND :evening = false AND a.afternoon = true) " +
        "OR (:morning = false AND :afternoon = false AND :evening = true AND a.evening = true) " +
        "OR (:morning = true AND :afternoon = true AND :evening = false AND (a.morning = true OR a.afternoon = true)) " +
        "OR (:morning = true AND :afternoon = false AND :evening = true AND (a.morning = true OR a.evening = true)) " +
        "OR (:morning = false AND :afternoon = true AND :evening = true AND (a.afternoon = true OR a.evening = true)) " +
        "OR (:morning = true AND :afternoon = true AND :evening = true)) " +
        /*"AND a.morning = :morning " +
        "AND a.evening = :evening " +
        "AND a.afternoon = :afternoon " +*/
        "AND st IN :serviceTypes")
    List<Mou3inaEntity> findAvailableProviders(
       @Param("serviceTypes") Collection<ServiceType> serviceTypes,
        @Param("desiredDate") Date desiredDate,
        @Param("morning") boolean morning,
        @Param("evening") boolean evening,
        @Param("afternoon") boolean afternoon);


////////////////////////////////////////////////
@Query("SELECT DISTINCT m FROM Mou3inaEntity m " +
        "JOIN AvailibilitiesMou3ina a ON m.id = a.Mou3inaEntity.id " +
        "JOIN m.serviceType st " +
        "WHERE a.date = :desiredDate " +
        "AND ((:morning = true AND :afternoon = false AND :evening = false AND a.morning = true) " +
        "OR (:morning = false AND :afternoon = true AND :evening = false AND a.afternoon = true) " +
        "OR (:morning = false AND :afternoon = false AND :evening = true AND a.evening = true) " +
        "OR (:morning = true AND :afternoon = true AND :evening = false AND (a.morning = true OR a.afternoon = true)) " +
        "OR (:morning = true AND :afternoon = false AND :evening = true AND (a.morning = true OR a.evening = true)) " +
        "OR (:morning = false AND :afternoon = true AND :evening = true AND (a.afternoon = true OR a.evening = true)) " +
        "OR (:morning = true AND :afternoon = true AND :evening = true)) " +
        "AND m.gouvernorat = :gouvernorat " +
        "AND m.deligation = :deligation " +
        "AND st IN :serviceTypes")
        List<Mou3inaEntity> filter(

                @Param("serviceTypes") Collection<ServiceType> serviceTypes,
                @Param("desiredDate") Date desiredDate,
                @Param("morning") boolean morning,
                @Param("evening") boolean evening,
                @Param("afternoon") boolean afternoon,
                @Param("gouvernorat") Gouvernorat gouvernorat,
                @Param("deligation") Delegation delegation);



    List<Mou3inaEntity> findByGouvernoratAndDeligation(Gouvernorat gouvernorat, Delegation deligation);


}
