package org.example.spring.basic_di.a_quickstart_set.Bean;

import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    private  Integer age;

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
