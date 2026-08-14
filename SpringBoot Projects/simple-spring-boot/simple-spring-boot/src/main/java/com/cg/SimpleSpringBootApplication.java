package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleSpringBootApplication {
	public static void main(String[] args) {
		//initialize the spring container ApplicationContext
		SpringApplication.run(SimpleSpringBootApplication.class, args);
	}

}
