package com.ktjr.service.controller;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
public class HelloController {

    @GetMapping("/hello")
    String hello(@RequestParam("name") String name) {
        // 取得HttpServletRequest
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.debug("收到请求，name={}", name);
        return "Hello " + name + ", I'm " + request.getLocalPort();
    }

}