package com.sofrecom.operation.admin.dao;

import com.sofrecom.operation.admin.entities.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerOrderMou3inaListRepository  extends
        JpaRepository<CustomerOrderMou3inaList, CustomerOrderMou3inaListId> {
	
	 @Query("SELECT u FROM CustomerOrderMou3inaList u where u.customerReservation.id=:id" )
		
	    List<CustomerOrderMou3inaList> findBymou3ina (long id);


}