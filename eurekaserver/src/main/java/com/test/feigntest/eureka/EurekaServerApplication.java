package com.test.feigntest.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @see <a href="http://www.jorgehernandezramirez.com/2017/03/16/spring-cloud-eureka-ribbon-feign/">Spring Cloud – Eureka + Ribbon + Feign</a>
 * @author dalonso
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
