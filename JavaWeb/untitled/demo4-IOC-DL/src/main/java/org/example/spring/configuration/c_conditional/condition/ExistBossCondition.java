package org.example.spring.configuration.c_conditional.condition;

import org.example.spring.configuration.c_conditional.component.Boss;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.lang.annotation.Annotation;

public class ExistBossCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.out.println("=======================");
        boolean isBossExist = context.getBeanFactory().containsBeanDefinition(Boss.class.getName());
        System.out.println("boss is exist!");
        return  isBossExist;
    }
    //只有ctx内有Boss定义时，才会满足条件
}
