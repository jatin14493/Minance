package com.minance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableAutoConfiguration
public class MinanceAssignment01Application {

	public static void main(String[] args) {
		SpringApplication.run(MinanceAssignment01Application.class, args);
	}
}
