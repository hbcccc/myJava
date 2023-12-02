package org.example.spring.annotation.f_propertyYML;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JdbcYmlPropertyApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcYmlConfiguration.class);
        System.out.println(ctx.getBean(JdbcYmlProperty.class).toString());
    }
}
