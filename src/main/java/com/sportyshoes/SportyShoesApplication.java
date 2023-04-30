package com.sportyshoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class SportyShoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyShoesApplication.class, args);
	}

}
