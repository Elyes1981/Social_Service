package com.example.demopfecamunda.provider.controller;


import com.example.demopfecamunda.provider.model.User;
import com.example.demopfecamunda.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/user/initiate")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE})
public class UserController {

    @Autowired
    UserService userService;


    //save user

    @GetMapping("/save")
public String initiateUser (){


    userService.initUser();

    return "user save with success";

    }

    @GetMapping("/allUser")
    public List<User> getAllUser(){
        return userService.findAllUsers();

    }
@GetMapping("/getById/{id}")
    public User getById(@PathVariable Long id){
        return userService.findUserById(id);

    }

}
