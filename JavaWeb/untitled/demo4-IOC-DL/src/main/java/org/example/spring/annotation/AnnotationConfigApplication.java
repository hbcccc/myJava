package org.example.spring.annotation;

import org.example.spring.basic_di.a_quickstart_set.Bean.Person ;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplication {
    public static void main(String[] args) {
        //通过配置类来注册bean，但这种方法在bean比较多时，会比较麻烦，每个要手动写
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(QuickstartConfiguration.class)

       //通过@Component注解来表明需要把这个类添加到bean， 并对Config类加入@ComponentScan注解来扫描和自动注册bean，省去了手工注册
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ComponentScanConfiguration.class);

        //配置类不使用@ComponentScan也行，输入参数设为需要Scan的basePackage路径就行
//        ApplicationContext ctx = new AnnotationConfigApplicationContext("org.example.spring.basic_di.a_quickstart_set.Bean");

        Person person = ctx.getBean(Person.class);
        System.out.println(person);
    }
}
