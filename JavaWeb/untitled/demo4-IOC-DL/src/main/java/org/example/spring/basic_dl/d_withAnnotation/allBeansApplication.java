package org.example.spring.basic_dl.d_withAnnotation;

import org.example.spring.basic_dl.d_withAnnotation.bean.Dog;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class allBeansApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("basic_dl/withAnnotation.xml");
        String[] beanNames = ctx.getBeanDefinitionNames();
        for(String name : beanNames){
            System.out.println(name);
            Object bean = ctx.getBean(name);
            System.out.println(bean);
        }

        //延迟查找
        ObjectProvider<Dog> dogProvider = ctx.getBeanProvider(Dog.class);
        Dog dog = dogProvider.getIfAvailable(Dog::new);
        System.out.println(dog);


    }
}
