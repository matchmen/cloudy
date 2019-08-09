package com.ktjr.service.controller;

import com.ktjr.service.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author a00002
 */
@RestController
@RequestMapping(value = "/api/v1")
public class FeginController {

    @Autowired
    FeignService feignService;

    @GetMapping(value = "/hello")
    public String hello(@RequestParam String name) {
        // 取得HttpServletRequest
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return "Fegin " + request.getLocalPort() + " > " + feignService.sayHello(name);
    }
}