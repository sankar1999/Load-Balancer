package com.loadbalancer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chatbook")
public class LoadBalancerController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/chat")
    public String chatNow() {
        return "Application is up on port: " + port ;
    }
}
