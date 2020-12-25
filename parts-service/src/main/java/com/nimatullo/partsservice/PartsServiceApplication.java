package com.nimatullo.partsservice;

import com.nimatullo.partsservice.db.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
public class PartsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartsServiceApplication.class, args);
	}

}
