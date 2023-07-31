package com.sofrecom.operation.customer.dao;

import com.sofrecom.operation.customer.entities.Distance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DistanceRepository extends JpaRepository<Distance, Long> {

    @Query("SELECT d.distance FROM Distance d WHERE d.customer.id = :customerId AND d.provider.id = :providerId")
    Double findDistanceByCustomerIdAndProviderId(@Param("customerId") Long customerId, @Param("providerId") Long providerId);

}
