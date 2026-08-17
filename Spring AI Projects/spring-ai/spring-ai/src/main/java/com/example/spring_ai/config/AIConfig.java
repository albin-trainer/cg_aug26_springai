package com.example.spring_ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.spring_ai.advisor.MyAdvisor;

@Configuration
public class AIConfig{
    @Bean
    @Primary
    public ChatClient configModel(ChatModel model){
        return ChatClient.builder(model).build();
    }
    
    @Bean ("advisor")
ChatClient chatClient(ChatClient.Builder builder,
                      MyAdvisor myAdvisor) {
    return builder
            .defaultAdvisors(myAdvisor)
            .build();
}
}