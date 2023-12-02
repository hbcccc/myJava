package org.example.spring.configuration.b_profile.config;

import org.example.spring.configuration.b_profile.component.Bar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BarConfiguration {
    @Bean
    public Bar bbbar(){
        return  new Bar();
    }
}
