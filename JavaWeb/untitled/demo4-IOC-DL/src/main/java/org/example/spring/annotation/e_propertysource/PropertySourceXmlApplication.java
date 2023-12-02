package org.example.spring.annotation.e_propertysource;

import org.example.spring.annotation.e_propertysource.bean.JdbcProperties;
import org.example.spring.annotation.e_propertysource.bean.JdbcXmlProperty;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertySourceXmlApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                JdbcXmlPropertiesConfiguration.class);
        System.out.println(ctx.getBean(JdbcXmlProperty.class).toString());

    }
}
