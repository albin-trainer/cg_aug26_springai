package com.example.spring_ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfig{
    @Bean
    public ChatClient configModel(ChatModel model){
        return ChatClient.builder(model).build();
    }
}