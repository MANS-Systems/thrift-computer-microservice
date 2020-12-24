package com.nimatullo.transactionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class TransactionServiceApplication {
	@Bean
	public RestTemplate getRestController(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(TransactionServiceApplication.class, args);
	}

}
