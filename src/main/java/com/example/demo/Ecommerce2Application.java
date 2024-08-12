package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.demo.model")
@EnableJpaRepositories(basePackages = "com.example.demo.repositories")
public class Ecommerce2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ecommerce2Application.class, args);
	}

}
