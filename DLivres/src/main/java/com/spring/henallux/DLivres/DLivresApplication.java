package com.spring.henallux.DLivres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class DLivresApplication {

	public static void main(String[] args) {
		SpringApplication.run(DLivresApplication.class, args);
	}

}
