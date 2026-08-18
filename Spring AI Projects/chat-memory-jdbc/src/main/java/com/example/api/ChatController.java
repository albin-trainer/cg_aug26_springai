package com.example.api;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

	private final ChatClient chatClient;
	private final ChatMemory chatMemory;
	 public ChatController(ChatClient chatClient, ChatMemory chatMemory) {
	        this.chatClient = chatClient;
			this.chatMemory=chatMemory;
	    }

	    @GetMapping("/chat")
	    public String chat(@RequestParam String uname,
	                       @RequestParam String message) {

	        return chatClient.prompt()
	                .user(message)
	                .advisors(a -> a.param(
	                        ChatMemory.CONVERSATION_ID,
	                        uname))
	                .call()
	                .content();
	    }
		    @GetMapping("/history")
public List<Message> getHistory(@RequestParam String uname) {
    return chatMemory.get(uname);
}

}
