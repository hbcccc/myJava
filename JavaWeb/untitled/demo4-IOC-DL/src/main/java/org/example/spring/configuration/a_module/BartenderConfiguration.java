package org.example.spring.configuration.a_module;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BartenderConfiguration {
    @Bean
    public Bartender zhangsan(){
        return new Bartender("张三");
    }
    @Bean
    public Bartender lisi(){
        return new Bartender("李四");
    }
}
