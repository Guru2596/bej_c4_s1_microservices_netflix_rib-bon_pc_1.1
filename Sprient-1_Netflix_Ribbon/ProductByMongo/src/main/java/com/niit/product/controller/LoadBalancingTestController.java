package com.niit.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

public class LoadBalancingTestController {
    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    @GetMapping("/loadbalancetest")
    public void getUser(){

        System.out.println("Inside Consumer");
        ResponseEntity<String> responseEntity = null;
        try{
            responseEntity = restTemplate.exchange("lb:http://AUTHENTICATION-SERVICE/searcher", HttpMethod.GET, getHeaders(), String.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private static HttpEntity<?> getHeaders() {
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(httpHeaders);
    }
}
