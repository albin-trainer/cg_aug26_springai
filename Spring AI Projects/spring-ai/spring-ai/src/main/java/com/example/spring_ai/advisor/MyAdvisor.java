package com.example.spring_ai.advisor;

import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;
import org.springframework.stereotype.Component;

@Component
public class MyAdvisor implements CallAdvisor {

    @Override
    public String getName() {
        return "MyAdvisor";
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public ChatClientResponse adviseCall(
            ChatClientRequest request,
            CallAdvisorChain chain) {

        System.out.println("User Prompt: "
                + request.prompt().getContents());

        // Continue to the next advisor / LLM
        ChatClientResponse response = chain.nextCall(request);

        System.out.println("LLM Response: "
                + response.chatResponse().getResult().getOutput().getText());

        return response;
    }
}