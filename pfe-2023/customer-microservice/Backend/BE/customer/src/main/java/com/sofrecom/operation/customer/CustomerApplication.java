package com.sofrecom.operation.customer;

import org.camunda.bpm.container.RuntimeContainerDelegate;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import static java.lang.System.getProperties;


@SpringBootApplication
@EnableProcessApplication
public class CustomerApplication {


    @Autowired
    private RuntimeService runtimeService;
    private RuntimeContainerDelegate runtimeDelegate;

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }


   protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder){
        return springApplicationBuilder
                .sources(CustomerApplication.class)
                .properties(getProperties());
    }

    /*@EventListener
    private void processPostDeploy(PostDeployEvent event) {
        String keyDefinition = null;
        runtimeService.startProcessInstanceByKey("customer");
        //RuntimeContainerDelegate runtimeContainerDelegate = RuntimeContainerDelegate.INSTANCE.get();        runtimeContainerDelegate.registerProcessEngine(processEngine);
    }*/
}
