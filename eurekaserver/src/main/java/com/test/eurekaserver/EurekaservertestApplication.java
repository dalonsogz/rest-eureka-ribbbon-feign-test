package com.test.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaservertestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaservertestApplication.class, args);
	}
}
