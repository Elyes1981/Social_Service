package com.c2s.fmwdiscoveryserver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class FmwDiscoveryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FmwDiscoveryServerApplication.class, args);
    }

}
