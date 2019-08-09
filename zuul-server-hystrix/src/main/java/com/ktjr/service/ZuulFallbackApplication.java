package com.ktjr.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author a00002
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZuulFallbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulFallbackApplication.class, args);
    }

}
