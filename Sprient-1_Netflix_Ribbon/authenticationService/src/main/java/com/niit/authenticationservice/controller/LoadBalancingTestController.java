package com.niit.authenticationservice.controller;

import com.niit.authenticationservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadBalancingTestController {

    @Autowired
    Environment environment;

    @GetMapping("/searcher")
    public User getUser(){
        User user = new User();
        user.setUsername("user1");
        user.setEmail("user1@niit.com");
        user.setPassword("user123");

        String serverPort = environment.getProperty("local.server.port");
        System.out.println("Request is served by instance running on: "+serverPort+" port");
        return user;
    }
}
