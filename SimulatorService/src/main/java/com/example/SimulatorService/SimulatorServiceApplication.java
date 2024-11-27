package com.example.SimulatorService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SimulatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimulatorServiceApplication.class, args);
	}

}
