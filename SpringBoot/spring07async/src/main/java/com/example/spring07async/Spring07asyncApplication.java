package com.example.spring07async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class Spring07asyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring07asyncApplication.class, args);
    }

}
