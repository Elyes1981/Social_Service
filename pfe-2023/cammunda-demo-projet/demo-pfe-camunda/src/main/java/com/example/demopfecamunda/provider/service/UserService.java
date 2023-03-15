package com.example.demopfecamunda.provider.service;


import com.example.demopfecamunda.provider.model.User;
import com.example.demopfecamunda.provider.repository.UserRepository;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class UserService {

    @Value("${spring.workflow.keydefinitionname}")
    private String keyDefinition ;

    @Autowired
    UserRepository userRepository;

    List<User> users = new ArrayList<>();

    public void initUser() {
        ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        String processInstanceId_1 =  runtimeService.startProcessInstanceByKey(keyDefinition).getProcessInstanceId();

        String processInstanceId_2 = runtimeService.startProcessInstanceByKey(keyDefinition).getProcessInstanceId();

        String processInstanceId_3 = runtimeService.startProcessInstanceByKey(keyDefinition).getProcessInstanceId();

        users = List.of(
                new User(null,"Selima","Lataeif","3 ans","30",processInstanceId_1),
                new User(null,"Moufida","Dhrif","4 ans","35",processInstanceId_2),
                new User(null,"Kaouther","ben Hmida","7 ans","54",processInstanceId_3)
        );

        for (User user: users
             ) {
            userRepository.save(user);
        }

    }


    public User findUserById(Long id){

        return  userRepository.findById(id).get();
    }
    public List<User> findAllUsers(){
        return  userRepository.findAll();


    }

}
