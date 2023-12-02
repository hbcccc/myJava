package org.example.spring.annotation;

import org.example.spring.annotation.Bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@ComponentScan("org.example.spring.annotation.Bean")
public class ConstructorInjectConfiguration {
    @Bean
    public Person person(){
        return new Person("hbc-byConstructorAnno",  10);
    }
}
