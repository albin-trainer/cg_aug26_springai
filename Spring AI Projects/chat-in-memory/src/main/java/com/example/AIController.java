package com.example;
import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.messages.Message;
import org.springframework.web.bind.annotation.*;

@RestController
public class AIController {
       private ChatClient chatClient;
       private 	ChatMemory chatMemory ;
      public AIController(ChatClient.Builder builder ) {
     		 chatMemory =
			    MessageWindowChatMemory.builder()
			        .chatMemoryRepository(new InMemoryChatMemoryRepository())
			        .build();
		this.chatClient = builder
			    .defaultAdvisors(
			        MessageChatMemoryAdvisor.builder(chatMemory).build()
			    )
			    .build();
    }
    @GetMapping("/history")
public List<Message> getHistory(@RequestParam String uname) {
    return chatMemory.get(uname);
}
    @GetMapping("/chat")
    public String chat(@RequestParam String prompt, @RequestParam String uname) {               
        return chatClient.prompt()
                .user(prompt)
                  .advisors(advisor -> advisor.param( ChatMemory.CONVERSATION_ID,
			        uname
			    ))
                .call()
                .content();
    }

   
}
