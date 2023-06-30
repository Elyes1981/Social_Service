package com.sofrecom.operation.customer;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.camunda.bpm.container.RuntimeContainerDelegate;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

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


    @Bean
    FirebaseMessaging firebaseMessaging() throws IOException {
        GoogleCredentials googleCredentials = GoogleCredentials
                .fromStream(new ClassPathResource("notification.json").getInputStream());
        FirebaseOptions firebaseOptions = FirebaseOptions
                .builder()
                .setCredentials(googleCredentials)
                .build();
        FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions, "YOUR APP NAME");
        return FirebaseMessaging.getInstance(app);
    }
    /*@EventListener
    private void processPostDeploy(PostDeployEvent event) {
        String keyDefinition = null;
        runtimeService.startProcessInstanceByKey("customer");
        //RuntimeContainerDelegate runtimeContainerDelegate = RuntimeContainerDelegate.INSTANCE.get();        runtimeContainerDelegate.registerProcessEngine(processEngine);
    }*/
}
