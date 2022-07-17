package com.example.ezenmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EzenmallApplication {

	public static void main(String[] args) {
		SpringApplication.run(EzenmallApplication.class, args);
	}
}
