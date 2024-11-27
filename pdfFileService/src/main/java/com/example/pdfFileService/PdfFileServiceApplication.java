package com.example.pdfFileService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PdfFileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfFileServiceApplication.class, args);
	}

}
