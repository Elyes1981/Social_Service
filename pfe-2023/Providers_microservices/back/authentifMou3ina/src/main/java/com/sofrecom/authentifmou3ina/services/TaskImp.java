package com.sofrecom.authentifmou3ina.services;

import com.sofrecom.authentifmou3ina.entities.Task;
import com.sofrecom.authentifmou3ina.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskImp implements ITaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task addTask(Task m) {
        return  taskRepository.save(m);
    }


    @Override
    public Task updateTask(Task m) {
        return taskRepository.saveAndFlush(m);
    }


    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findTask(Long id) {
        Task m=(Task) taskRepository.findById(id).get();
        return m;
    }


    @Override
    public void deleteTask(Long id) {
        if(taskRepository.findById(id).isPresent())
            taskRepository.deleteById(id);

    }


    @Override
    public List<Task> findTaskMou3ina(String idMou3ina) {

        return taskRepository.findByIdMou3ina(idMou3ina);
    }








}
