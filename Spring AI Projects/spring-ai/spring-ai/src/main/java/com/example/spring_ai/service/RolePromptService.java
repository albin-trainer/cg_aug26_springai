package com.example.spring_ai.service;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;
@Service
public class RolePromptService {
    private  final ChatClient chatClient;
public RolePromptService ( ChatClient chatClient){
    this.chatClient=chatClient;
}public String analyzeReview(RoleReviewRequest request) {

    String userPrompt = """
            Analyze the following customer review.

            Review:
            {review}

            Give your response in simple language based on the role
            and address to the reviewer
            dont add fillers
            """;

    PromptTemplate userTemplate = new PromptTemplate(userPrompt);

    Prompt userPromptObj = userTemplate.create(
            Map.of("review", request.review())
    );

    var userMessage = new UserMessage(userPromptObj.getContents());

    String sysMsg = """
            You are an experienced {role}.

            Analyze customer reviews from the perspective
            of this professional role.

            Focus only on information relevant to the review.
            """;

    PromptTemplate systemTemplate = new PromptTemplate(sysMsg);

    Prompt systemPrompt = systemTemplate.create(
            Map.of("role", request.role())
    );

    var systemMessage = new SystemMessage(systemPrompt.getContents());

    Prompt finalPrompt = new Prompt(
            List.of(systemMessage, userMessage)
    );

    return chatClient
            .prompt(finalPrompt)
            .call()
            .content();
}
}
