package com.ktjr.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author a00002
 */
@EnableEurekaClient
@SpringBootApplication
public class ServiceApplication_A {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication_A.class, args);
	}

}
