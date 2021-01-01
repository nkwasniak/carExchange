package com.nkwasniak.carExchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarExchangeApplication {
	private static final Logger log = LoggerFactory.getLogger(CarExchangeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarExchangeApplication.class, args);
	}
}
