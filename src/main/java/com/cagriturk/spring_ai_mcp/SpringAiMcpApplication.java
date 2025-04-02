package com.cagriturk.spring_ai_mcp;

import java.util.List;

import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbacks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cagriturk.spring_ai_mcp.service.PersonService;

@SpringBootApplication
public class SpringAiMcpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAiMcpApplication.class, args);
	}

	@Bean
	public List<ToolCallback> toolCallbacks(PersonService personService) {
		return List.of(ToolCallbacks.from(personService));
	}

}
