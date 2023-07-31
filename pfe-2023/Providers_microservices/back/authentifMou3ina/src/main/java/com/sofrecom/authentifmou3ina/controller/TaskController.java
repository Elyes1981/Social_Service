package com.sofrecom.authentifmou3ina.controller;

import com.sofrecom.authentifmou3ina.entities.Task;
import com.sofrecom.authentifmou3ina.services.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TaskController {
    @Autowired
    ITaskService itaskService;
    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<Task> findTasks() {
        return itaskService.findAll();
    }
    @GetMapping(value = "/Task/{id}")
    public Task findOneTaskById(@PathVariable Long id) {
        return itaskService.findTask(id);
    }
    @GetMapping(value = "/Tasks/{idMou3ina}")
    public List<Task> findOneTaskByIdMou3ina(@PathVariable String idMou3ina) {
        return itaskService.findTaskMou3ina(idMou3ina);
    }
    @PostMapping(value = "/Task/newTask")
    public Task addTask(@RequestBody Task m) {
        return itaskService.addTask(m);
    }
    @PutMapping(value = "/Tasks/Task/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task p) {
        p.setId(id);
        return itaskService.updateTask(p);
    }

    @DeleteMapping(value = "/deleteTask/{id}")
    public void deleteTask(@PathVariable Long id) {
        itaskService.deleteTask(id);
    }





}
