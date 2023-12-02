package org.example.c67;

import org.example.c67.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UserConfiguration {
    @Bean
    public UserService userService(){
        return  new UserService();
    }

}
