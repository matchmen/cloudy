package com.ktjr.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author a00002
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication_1 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication_1.class, args);
    }

}
