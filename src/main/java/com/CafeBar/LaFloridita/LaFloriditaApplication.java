package com.CafeBar.LaFloridita;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class LaFloriditaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaFloriditaApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
		};
	}


}
