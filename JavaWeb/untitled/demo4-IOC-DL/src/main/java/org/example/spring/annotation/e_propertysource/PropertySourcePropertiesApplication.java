package org.example.spring.annotation.e_propertysource;

import org.example.spring.annotation.AnnotationConfigApplication;
import org.example.spring.annotation.e_propertysource.bean.JdbcProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertySourcePropertiesApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                JdbcPropertiesConfiguration.class);
        System.out.println(ctx.getBean(JdbcProperties.class).toString());

    }
}
