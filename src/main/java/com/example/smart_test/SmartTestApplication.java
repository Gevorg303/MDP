package com.example.smart_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@EnableTransactionManagement
public class SmartTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartTestApplication.class, args);
	}

}
