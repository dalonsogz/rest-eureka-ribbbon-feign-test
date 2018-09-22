package com.test.feigntest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @see <a href="http://www.jorgehernandezramirez.com/2017/03/16/spring-cloud-eureka-ribbon-feign/">Spring Cloud – Eureka + Ribbon + Feign</a>
 * @author dalonso
 *
 */
@SpringBootApplication //(scanBasePackages={"com.test.feigntest.feign", "com.test.feigntest.controller"})
@EnableDiscoveryClient
@EnableFeignClients("com.test.feigntest.feign")
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
}
