package org.example.spring.configuration.a_module;

import org.example.spring.configuration.c_conditional.condition.ExistBossCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BarConfiguration {
    @Bean
    public Bar bbbar(){
        return  new Bar();
    }
}
