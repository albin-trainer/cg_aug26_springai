package com.example;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.RestController;

import com.example.tools.WeatherAppTool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class AIController {

    private final ChatClient chatClient;

    public AIController(ChatClient.Builder builder,
                        WeatherAppTool weatherTool) {
        this.chatClient = builder
                .defaultTools(weatherTool)
                .build();
    }
@GetMapping("/chat")
    public String chat( @RequestParam String prompt){
          return chatClient.prompt()
                .user(prompt)
                .call()
                .content();

    }
}
