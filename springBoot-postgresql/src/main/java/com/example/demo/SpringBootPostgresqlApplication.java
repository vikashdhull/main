package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootPostgresqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPostgresqlApplication.class, args);
	}

}
