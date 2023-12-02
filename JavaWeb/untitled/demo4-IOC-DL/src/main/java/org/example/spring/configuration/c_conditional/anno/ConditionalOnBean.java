package org.example.spring.configuration.c_conditional.anno;

import org.example.spring.configuration.c_conditional.condition.onBeanCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Conditional(onBeanCondition.class)
public @interface ConditionalOnBean {
    Class<?>[] value() default {};

    String[] beanNames() default {};
}
