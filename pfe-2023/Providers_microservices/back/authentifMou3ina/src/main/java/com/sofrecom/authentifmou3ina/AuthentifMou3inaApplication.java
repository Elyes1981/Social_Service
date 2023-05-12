package com.sofrecom.authentifmou3ina;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.camunda.bpm.container.RuntimeContainerDelegate;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;


import java.io.IOException;
import java.util.Properties;
//@EnableEurekaClient
// you can stand up a client that both registers itself with the registry
// and uses the Spring Cloud DiscoveryClient abstraction to interrogate the registry for its own host and port.
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableProcessApplication
public class AuthentifMou3inaApplication {
    @Autowired
    private RuntimeService runtimeService ;
    //private RuntimeContainerDelegate runtimeDelegate ;

    public static void main(String[] args) {
        SpringApplication.run(AuthentifMou3inaApplication.class, args);
    }

    static Properties getProperties() {
        Properties props = new Properties();
        props.put("spring.config.name", "application");
        return props;
    }

    //@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder
                .sources(AuthentifMou3inaApplication.class)
                .properties(getProperties());
    }

    /*@EventListener
    private void processPostDeploy(PostDeployEvent event) {
        runtimeService.startProcessInstanceByKey("ProvidersProcess") ;
        RuntimeContainerDelegate runtimeContainerDelegate = RuntimeContainerDelegate.INSTANCE.get();
//        runtimeContainerDelegate.registerProcessEngine(processEngine);
    }*/

    //Here new ClassPathResource("firebase-service-account.json").getInputStream()
    // is an easier way to create an InputStream for a file that is in classpath. $
    // With this we created a FirebaseApp object from which we got our FirebaseMessaging instance.
    @Bean
    FirebaseMessaging firebaseMessageMobile() throws IOException {
        GoogleCredentials googleCredentials = GoogleCredentials
                .fromStream(new ClassPathResource("providers-services-firebase-adminsdk-kji3d-b7b4c8b8bf.json").getInputStream());
        FirebaseOptions firebaseOptions = FirebaseOptions
                .builder()
                .setCredentials(googleCredentials)
                .build();
        FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions);
        return FirebaseMessaging.getInstance(app);
    }
    @Bean
    FirebaseMessaging firebaseMessageWeb() throws IOException {
        GoogleCredentials googleCredentials = GoogleCredentials
                .fromStream(new ClassPathResource("operation-admin-fe-firebase-adminsdk-o6tsg-3a4669912c.json").getInputStream());
        FirebaseOptions firebaseOptions = FirebaseOptions
                .builder()
                .setCredentials(googleCredentials)
                .build();
        FirebaseApp applica = FirebaseApp.initializeApp(firebaseOptions, "my-applica");
        return FirebaseMessaging.getInstance(applica);
    }
}
