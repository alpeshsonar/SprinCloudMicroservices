package com.microservice.visit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PatientVisitService
{
	public static void main(String[] args)
	{
		SpringApplication.run(PatientVisitService.class, args);
	}
}
