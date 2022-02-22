package com.niit.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "productservice",configuration = RibbonClientConfiguration.class)

public class ProductByMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductByMongoApplication.class, args);
	}

	@LoadBalanced
	@Bean
	RestTemplate loadBalancing(){
		return new RestTemplate();
	}

}
