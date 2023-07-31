package com.sofrecom.authentifmou3ina.repository;

import com.sofrecom.authentifmou3ina.entities.Delegation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface DelegationRepository extends JpaRepository<Delegation, Long> {

}
