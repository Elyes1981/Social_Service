package com.sofrecom.operation.admin.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sofrecom.operation.admin.entities.ERole;
import com.sofrecom.operation.admin.entities.Role;

@Repository

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}