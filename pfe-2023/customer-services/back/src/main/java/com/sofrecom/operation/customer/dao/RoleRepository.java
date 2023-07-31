package com.sofrecom.operation.customer.dao;

import com.sofrecom.operation.customer.entities.ERole;
import com.sofrecom.operation.customer.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}