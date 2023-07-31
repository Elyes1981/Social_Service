package com.sofrecom.uss.operation.repository;

import com.sofrecom.uss.operation.entities.CustomerForOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerForOperationRepository  extends JpaRepository<CustomerForOperation, Long> {
}
