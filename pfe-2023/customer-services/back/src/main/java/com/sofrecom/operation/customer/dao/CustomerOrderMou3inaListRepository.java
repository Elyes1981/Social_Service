package com.sofrecom.operation.customer.dao;
import com.sofrecom.operation.customer.entities.CustomerOrderMou3inaList;
import com.sofrecom.operation.customer.entities.CustomerOrderMou3inaListId;
import com.sofrecom.operation.customer.entities.CustomerReservation;
import com.sofrecom.operation.customer.entities.Mou3inaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CustomerOrderMou3inaListRepository  extends JpaRepository<CustomerOrderMou3inaList, CustomerOrderMou3inaListId> {
	
	 @Query("SELECT u FROM CustomerOrderMou3inaList u where u.customerReservation.id=:id" )
	 CustomerOrderMou3inaList findBymou3ina (long id);

	 List<CustomerOrderMou3inaList> findByMou3ina(Mou3inaEntity provider) ;

	@Query("from CustomerOrderMou3inaList s where DATE(s.OrderDay) = :date ")
	public List<CustomerOrderMou3inaList> getsome(Date date);

	List<CustomerOrderMou3inaList> findByCustomerReservation (CustomerReservation customerReservation);

	@Query("select i from CustomerOrderMou3inaList i where UPPER( i.customerReservation.status )  like concat('', concat(:statuscode, '%'))  " )
	public List<CustomerOrderMou3inaList> getstatus( String statuscode);

	@Query("select s from CustomerOrderMou3inaList s where DATE(s.customerReservation.desiredHour) = :desiredHour" )
	public List<CustomerOrderMou3inaList> getHour( Date desiredHour);



	@Query(value = "SELECT u FROM CustomerOrderMou3inaList u  WHERE u.mou3ina.id =:idmou3ina and EXTRACT(YEAR FROM u.OrderDay)=:year" )
	List<CustomerOrderMou3inaList> findAllByMou3inaID(Long idmou3ina, Integer year);

	List<CustomerOrderMou3inaList> findByMou3inaId(Long mou3inaId);

	@Query("SELECT SUM(c.serviceCost) FROM CustomerOrderMou3inaList c WHERE c.customerReservation.id = :customerReservationId")
	Double calculateTotalServiceCostByCustomerReservation(@Param("customerReservationId") Long customerReservationId);


	@Query(value = "SELECT  EXTRACT(MONTH FROM customer_order_mou3ina_list.order_day) AS orderMonth,\r\n"
			+ "count(*) as numbreCommande FROM customer_order_mou3ina_list where \r\n"
			+ "EXTRACT(YEAR FROM customer_order_mou3ina_list.order_day)=:year  AND \r\n"
			+ "customer_order_mou3ina_list.mou3ina_mou3ina_id  =:idmou3ina\r\n"
			+ "GROUP BY  EXTRACT(MONTH FROM customer_order_mou3ina_list.order_day) \r\n"
			+ "ORDER BY EXTRACT(MONTH FROM customer_order_mou3ina_list.order_day)\r\n"
			+ ""
			, nativeQuery = true)
	List<Object[]> findMou3inaOrdersByYearByMonth(long year ,long idmou3ina);


//	List<CustomerOrderMou3inaList> findByMou3inaAndOrderDayGreaterThanEqual(Mou3inaEntity mou3ina, Date orderDay);




}