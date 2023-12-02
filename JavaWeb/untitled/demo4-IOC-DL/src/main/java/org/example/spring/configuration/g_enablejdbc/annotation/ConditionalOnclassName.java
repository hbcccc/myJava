package org.example.spring.configuration.g_enablejdbc.annotation;

import org.example.spring.configuration.g_enablejdbc.Component.OnClassNameConditional;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Conditional(OnClassNameConditional.class)
public @interface ConditionalOnclassName {
    String value();
}
