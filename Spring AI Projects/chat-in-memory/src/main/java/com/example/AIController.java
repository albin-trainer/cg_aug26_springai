package com.example;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIController {
    @Autowired
 private ChatClient chatClient;

    @GetMapping("/chat")
public String chat( @RequestParam String prompt, 
    @RequestParam String uname){
        return chatClient.prompt().user(prompt).call().content();

}
}
