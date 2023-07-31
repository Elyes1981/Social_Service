package com.sofrecom.authentifmou3ina.services;

import com.sofrecom.authentifmou3ina.entities.Task;

import java.util.List;

public interface ITaskService {
    public Task addTask(Task m);

    public void deleteTask(Long id);

    public Task  updateTask (Task m);









    public List<Task> findAll();

    public Task findTask(Long id);
    public List<Task> findTaskMou3ina(String idMou3ina);
}


