package org.example.spring.annotation.a_AttributeInject;

import org.example.spring.annotation.Bean.Person;
import org.example.spring.annotation.Bean.Blue;
import org.example.spring.annotation.Bean.Red;
import org.example.spring.annotation.ComponentScanConfiguration;
import org.example.spring.annotation.ConstructorInjectConfiguration;
import org.example.spring.annotation.InjectValueConfiguration;
import org.example.spring.annotation.QuickstartConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorInjectApplication {
    public static void main(String[] args) {
        //通过XML方式的构造器注入
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("annotationIOC/attributeInject/attriIject.xml");

        //通过配置类的构造器注入（配置类内使用@Bean注解来注册bean）
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(ConstructorInjectConfiguration.class);

//        Person hbc = ctx.getBean(Person.class);
//        System.out.println(hbc);


        // 那如果不是在配置类内部用@Bean这种来注册bean，而是使用ComponentScan的方式来注册呢？
        // 此时如何注入属性？
        // 答案：在类的属性上，使用@Value注解
//        ApplicationContext ctx = new AnnotationConfigApplicationContext("org.example.spring.annotation.Bean");
//        Blue blue = ctx.getBean(Blue.class);
//        System.out.println(blue);


        //如果想用外部的配置来作为属性注入呢？eg, xx.properties，用户来写属性信息
        ApplicationContext ctx = new AnnotationConfigApplicationContext(InjectValueConfiguration.class);
        Red red = ctx.getBean(Red.class);
        System.out.println(red);

    }
}
