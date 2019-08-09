package com.ktjr.service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jianglongtao
 */
@FeignClient(value = "service-hello", fallback = FeignServiceHystrix.class)
public interface FeignService {

    @GetMapping(value = "/api/v1/hello")
    String sayHello(@RequestParam(value = "name") String name);

}


