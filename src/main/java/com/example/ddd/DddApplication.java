package com.example.ddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DddApplication {

	public static void main(String[] args) {
		SpringApplication.run(DddApplication.class, args);
	}

}
