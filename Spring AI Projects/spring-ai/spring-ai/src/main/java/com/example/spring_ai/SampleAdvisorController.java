package com.example.spring_ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advisor")
public class SampleAdvisorController {

    private final ChatClient chatClient;

    public SampleAdvisorController( @Qualifier("advisor") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/ask")
    public String ask(@RequestParam String prompt) {

        return chatClient
                .prompt(prompt)
                .call()
                .content();
    }
}