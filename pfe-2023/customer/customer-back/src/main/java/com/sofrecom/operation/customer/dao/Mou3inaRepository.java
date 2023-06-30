package com.sofrecom.operation.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sofrecom.operation.customer.entities.Mou3inaEntity;

import java.util.List;

public interface Mou3inaRepository extends JpaRepository<Mou3inaEntity, Long> {


    List<Mou3inaEntity> findByServiceType_LabelIn(List<String> ids);
}
