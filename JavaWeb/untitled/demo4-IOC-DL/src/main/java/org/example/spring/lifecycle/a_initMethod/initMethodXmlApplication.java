package org.example.spring.lifecycle.a_initMethod;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class initMethodXmlApplication {
    public static void main(String[] args) {
        System.out.println("准备初始化IOC容器。。。");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("lifecycle/initMehod.xml");
        System.out.println("IOC容器初始化完成。。。");

        System.out.println();

        System.out.println("准备销毁IOC容器。。。");
        ctx.close();
        System.out.println("IOC容器销毁完成。。。");

    }
}
