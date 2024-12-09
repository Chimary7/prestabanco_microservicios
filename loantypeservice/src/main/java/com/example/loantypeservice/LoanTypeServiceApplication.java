package com.example.loantypeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LoanTypeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanTypeServiceApplication.class, args);
	}

}