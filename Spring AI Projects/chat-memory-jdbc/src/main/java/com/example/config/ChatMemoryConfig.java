package com.example.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ChatMemoryConfig {
	@Bean
	public JdbcChatMemoryRepository chatMemoryRepository(JdbcTemplate jdbcTemplate) {

	    return JdbcChatMemoryRepository.builder()
	            .jdbcTemplate(jdbcTemplate)
	            .build();
	}
	
	@Bean
	public ChatMemory chatMemory(JdbcChatMemoryRepository repository) {

	    return MessageWindowChatMemory.builder()
	            .chatMemoryRepository(repository)
	            .maxMessages(20)
	            .build();
	}
	
	@Bean
	public ChatClient chatClient(ChatClient.Builder builder,
	                             ChatMemory chatMemory) {

	    return builder
	            .defaultAdvisors(
	                    MessageChatMemoryAdvisor.builder(chatMemory).build()
	            )
	            .build();
	}
}
