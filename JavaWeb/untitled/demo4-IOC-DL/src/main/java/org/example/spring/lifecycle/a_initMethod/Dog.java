package org.example.spring.lifecycle.a_initMethod;

public class Dog {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println(name + "被初始化了。。。");
    }
    public void destroy() {
        System.out.println(name + "被销毁了。。。");
    }
}
