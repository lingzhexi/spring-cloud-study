package com.codeling.eurekanode02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaNode02Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaNode02Application.class, args);
    }

}
