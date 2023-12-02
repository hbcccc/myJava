package org.example.spring.annotation.Bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class Person {
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    @Value("hbc-by@Value")
    private String name;

    @Value("98")
    private Integer age;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
