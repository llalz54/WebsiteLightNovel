package com.example.ClientBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@SpringBootApplication
public class ClientBookApplication {

	@Bean
	RestTemplate restTemplate() {
		RestTemplate template = new RestTemplate();
		DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory("http://localhost:8099");
		template.setUriTemplateHandler(defaultUriBuilderFactory);
		return template;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ClientBookApplication.class, args);
	}

}
