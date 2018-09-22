package com.test.feigntest;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
 
@Configuration
public class RestTemplateConfiguration {
 
    @Bean
    @LoadBalanced
    RestTemplate loadBalancedRestTemplate() {
        return new RestTemplate();
    }
    
//    @FeignClient("SPRINGCLOUDWEBTEST")
//    public interface TestFeign {
//     
//        @RequestMapping(value="/ping", method = RequestMethod.GET)
//        String doAlive();
//    }
}
