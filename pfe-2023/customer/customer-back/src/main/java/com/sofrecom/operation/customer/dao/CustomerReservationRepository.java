package com.sofrecom.operation.customer.dao;


import com.sofrecom.operation.customer.entities.CustomerReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CustomerReservationRepository extends JpaRepository<CustomerReservation, Long> {

    Optional<CustomerReservation> findById(Long Id);

    List<CustomerReservation> findAllByOrderByIdDesc();

    @Query("from CustomerReservation s where DATE(s.desiredDate) = :date ")
    public List<CustomerReservation> getsome(Date date);
    /*
            @Query("select i from CustomerReservation i where UPPER( i.serviceTypes.Label ) like concat('', concat(:serviceType, '%')) OR  UPPER(i.serviceTypes.Label_fr ) like concat('', concat(:serviceType, '%')) OR  i.serviceTypes.Label  like concat('', concat(:serviceType, '%')) OR i.serviceTypeId.Label_fr  like concat('', concat(:serviceType, '%')) OR i.serviceTypes.Label_ar  like concat('', concat(:serviceType, '%'))  " )
            public List<CustomerReservation> getservicetype( String serviceType);
    */
    @Query("from CustomerReservation i where  i.gradeAverage = :grade " )
    public List<CustomerReservation> getgrade( int grade);
    @Query("from CustomerReservation i where  i.numberOfMou3ina = :nb " )
    public List<CustomerReservation> getnumbermo3ina( int nb);

    @Query("select i from CustomerReservation i where UPPER( i.statuscode.status_en ) like concat('', concat(:statuscode, '%')) OR  UPPER(i.statuscode.status_fr ) like concat('', concat(:statuscode, '%')) OR  i.statuscode.status_en  like concat('', concat(:statuscode, '%')) OR i.statuscode.status_fr  like concat('', concat(:statuscode, '%')) OR i.statuscode.status_ar  like concat('', concat(:statuscode, '%'))  " )
    public List<CustomerReservation> getstatus( String statuscode);

    @Query("SELECT u FROM CustomerReservation u where u.customer.id=:id" )

    List<CustomerReservation> findByCustomer(long id);

}
