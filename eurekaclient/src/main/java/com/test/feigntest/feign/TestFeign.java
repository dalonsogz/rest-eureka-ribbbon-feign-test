package com.test.feigntest.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("SPRINGCLOUDWEBTEST")
//@FeignClient("springcloudwebtest")
public interface TestFeign {
 
    @RequestMapping(value="/ping", method = RequestMethod.GET)
    String doAlive();
}
