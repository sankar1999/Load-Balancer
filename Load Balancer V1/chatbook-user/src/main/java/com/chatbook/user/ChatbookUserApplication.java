package com.chatbook.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name = "chatbook", configuration = RibbonConfiguration.class)
public class ChatbookUserApplication {

	@Autowired
	private RestTemplate template;

	@GetMapping("/invoke")
	public String invokeChatbook() {
		String url = "http://chatbook/chatbook/chat";
		return template.getForObject(url, String.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ChatbookUserApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
