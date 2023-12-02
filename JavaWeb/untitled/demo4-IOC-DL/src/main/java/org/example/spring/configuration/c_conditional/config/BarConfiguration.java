package org.example.spring.configuration.c_conditional.config;

import org.example.spring.configuration.c_conditional.anno.ConditionalOnBean;
import org.example.spring.configuration.c_conditional.component.Bar;
import org.example.spring.configuration.c_conditional.component.Boss;
import org.example.spring.configuration.c_conditional.condition.ExistBossCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BarConfiguration {
    @Bean
//    @Conditional(ExistBossCondition.class)//满足condition时，才会注入bbbar这个bean
    @ConditionalOnBean(Boss.class)
    public Bar bbbar(){
        return  new Bar();
    }
}
