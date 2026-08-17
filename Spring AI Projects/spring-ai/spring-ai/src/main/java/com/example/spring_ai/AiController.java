package com.example.spring_ai;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_ai.dto.Player;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class AiController {
   // @Autowired
private  final ChatClient chatClient;
public AiController ( ChatClient chatClient){
    this.chatClient=chatClient;
}

@GetMapping("/prompt")
public String prompt(@RequestParam String prompt){
    return chatClient.prompt(prompt).call().content();
}
//http://localhost:8080/sports?sports=Cricket
@GetMapping("/sports")
public String getFamousPersonalitiesInSports( @RequestParam String sports){
    String prompt="""
    List top 5 personalities 
    in {sports} with their carrier achivements
    Give in proper format with bullets
    """;
    PromptTemplate template=new PromptTemplate(prompt);
    Prompt p=template.create(Map.of("sports", sports)) ;        
    return chatClient.prompt(p).call().content();
}
@GetMapping("/onlysports")
public String getFamousPersonalitiesOnlyInSports( @RequestParam String sports){
    String prompt="""
    List top 5 personalities 
    in {sports} with their carrier achivements
    Give in proper format with bullets
    """;
    PromptTemplate template=new PromptTemplate(prompt);
    Prompt p=template.create(Map.of("sports", sports)) ;   
    var userMessage = new UserMessage(p.getContents());
    String sysMsg="""
                Your primary function is share information about only sports,
                if someone ask something else, say i ll share information about only sports
            """;
    var systemMessage= new SystemMessage(sysMsg)  ;
    Prompt finalPrompt=new Prompt(List.of(userMessage,systemMessage)) ;
    return chatClient.prompt(finalPrompt).call().content();
}

	@GetMapping("/beanconverter")
	public Player beanoutputconvertor(@RequestParam  String sports) {
		BeanOutputConverter<Player> converter=
				new BeanOutputConverter<Player>(Player.class);
		String msg="""
				Generate a list of career achievements for 1 popular personalities in {sports}  
				include the player as the key and the achievements as List of value 
				{format}
				""";
		
		PromptTemplate promptTemplate= new PromptTemplate(msg);
		Prompt prompt= promptTemplate.create( Map.of("sports",sports,"format",converter.getFormat()) );
		ChatResponse chatResp=  chatClient.prompt(prompt).call().chatResponse();
		String output = chatResp.getResult().getOutput().getText();
		System.out.println(output);
		return converter.convert(chatResp.getResult().getOutput().getText());
	}		
}
