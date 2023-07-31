package com.sofrecom.authentifmou3ina.repository;

import java.util.Optional;

import com.sofrecom.authentifmou3ina.entities.ERole;
import com.sofrecom.authentifmou3ina.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository

public interface RoleRepository extends JpaRepository<Role, Long> {
Optional<Role> findByName(ERole name);
}