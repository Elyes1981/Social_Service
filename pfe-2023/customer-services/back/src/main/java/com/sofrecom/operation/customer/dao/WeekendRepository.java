package com.sofrecom.operation.customer.dao;

import com.sofrecom.operation.customer.entities.Weekend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WeekendRepository extends JpaRepository<Weekend, Long> {
    @Query("SELECT u FROM Weekend u WHERE u.Mou3inaEntity.id =:e")
    List<Weekend> findByMou3inaEntity(long e);

    @Query("SELECT u FROM Weekend u  WHERE u.Mou3inaEntity.id =:e AND EXTRACT(YEAR FROM u.date) =:year")
    List<Weekend> findByMou3inaEntitya(Long e, Integer year);

}
