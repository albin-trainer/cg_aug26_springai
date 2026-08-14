package com.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootTest
class BasicSpringSecurityApplicationTests {

	@Autowired
	private UserDetailsService userDetailsService;

	@Test
	void contextLoads() {
	}

	@Test
	void inMemoryUsersShouldBeAvailable() {
		assertNotNull(userDetailsService.loadUserByUsername("admin"));
		assertNotNull(userDetailsService.loadUserByUsername("Albin"));
	}

}
