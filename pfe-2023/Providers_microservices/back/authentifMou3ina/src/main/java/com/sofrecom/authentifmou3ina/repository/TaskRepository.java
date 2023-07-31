package com.sofrecom.authentifmou3ina.repository;

import com.sofrecom.authentifmou3ina.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository   extends JpaRepository<Task, Long> {
    List<Task> findByIdMou3ina(String idMou3ina);

}
