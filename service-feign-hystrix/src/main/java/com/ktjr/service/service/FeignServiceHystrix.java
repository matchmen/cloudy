package com.ktjr.service.service;

import org.springframework.stereotype.Component;

/**
 * @author jianglongtao
 */
@Component
public class FeignServiceHystrix implements FeignService {

    @Override
    public String sayHello(String name) {
        return "Hello," + name + ", Service is error now!";
    }

}
