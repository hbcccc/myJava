package org.example.spring.annotation;

import org.example.spring.basic_di.a_quickstart_set.Bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//此类作为配置类

@Configuration
public class QuickstartConfiguration {
    @Bean(name = "hbc") //相当于xml bean的id， 默认为类名的小写开头（person）
    public Person person(){
        Person person = new Person();
        person.setName("hbccc");
        person.setAge(23);
        return person;
    }
}
