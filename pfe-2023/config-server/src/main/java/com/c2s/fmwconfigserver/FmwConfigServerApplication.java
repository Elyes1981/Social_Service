package com.c2s.fmwconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class FmwConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FmwConfigServerApplication.class, args);
    }

}
