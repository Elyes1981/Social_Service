package com.example.demopfecamunda;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.event.EventListener;

import java.util.Properties;

@SpringBootApplication
@EnableProcessApplication
public class DemoPfeCamundaApplication extends SpringBootServletInitializer {
    @Autowired
    private RuntimeService runtimeService;
    public static void main(String[] args) {
        SpringApplication.run(DemoPfeCamundaApplication.class, args);
    }

    static Properties getProperties() {
        Properties props = new Properties();
        props.put("spring.config.name", "application");
        return props;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder
                .sources(DemoPfeCamundaApplication.class)
                .properties(getProperties());
    }

}
