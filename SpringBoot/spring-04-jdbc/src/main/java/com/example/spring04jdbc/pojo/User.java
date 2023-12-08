package com.example.spring04jdbc.pojo;


public class User {
    public String name;
    public Integer age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
