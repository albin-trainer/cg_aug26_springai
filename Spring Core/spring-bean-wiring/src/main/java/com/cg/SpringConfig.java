package com.cg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.cg") 
public class SpringConfig {
	/*@Bean
	public AccountRepository accountRepository() {
		return new AccountRepositoryImpl();
	}*/
	@Bean
	public AccountService accountService() {
		return new AccountServiceImpl();
	}
}
