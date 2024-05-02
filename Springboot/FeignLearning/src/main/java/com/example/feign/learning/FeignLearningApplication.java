package com.example.feign.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.feign.learning.clients")
public class FeignLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignLearningApplication.class, args);
	}

}
