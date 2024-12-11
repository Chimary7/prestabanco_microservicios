package com.example.creditMonitoringService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CreditMonitoringServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditMonitoringServiceApplication.class, args);
	}

}
