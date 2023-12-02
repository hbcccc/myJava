package com.hbc.helloworld.controller;

import com.hbc.helloworld.pojo.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    Cat cat;
    @RequestMapping("/hello")
    public String hello(){
        return "hello, world! cat name from:"+ cat.getName();
    }
}
