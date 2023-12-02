package org.example.spring.basic_dl.d_withAnnotation;

import org.example.spring.basic_dl.d_withAnnotation.Annotations.Color;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class withAnnotationApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("basic_dl/withAnnotation.xml");
        Map<String, Object> beans = ctx.getBeansWithAnnotation(Color.class);
        beans.forEach((bName, bean) ->{
            System.out.println(bName + " : " + bean);
        });
    }
}
