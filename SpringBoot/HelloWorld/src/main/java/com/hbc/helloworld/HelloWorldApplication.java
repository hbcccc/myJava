package com.hbc.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

//程序的主入口
@SpringBootApplication

public class HelloWorldApplication {

	private String email;

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
