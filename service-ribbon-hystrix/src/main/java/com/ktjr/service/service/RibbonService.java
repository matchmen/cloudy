package com.ktjr.service.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author jianglongtao
 */
@Service
public class RibbonService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 添加 @HystrixCommand, 指定熔断方法
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "helloError")
    public String helloService(String name) {
        return restTemplate.getForObject("http://SERVICE-HELLO/api/v1/hello?name=" + name, String.class);
    }

    public String helloError(String name) {
        return "Hello," + name +", Service is error now!";
    }
}
