package com.example.demopfecamunda.provider.repository;

import com.example.demopfecamunda.provider.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


}
