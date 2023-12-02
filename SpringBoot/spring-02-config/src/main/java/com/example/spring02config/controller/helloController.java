package com.example.spring02config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class helloController {
    @RequestMapping("/")
    public String hello(){
        return "index";
    }
}
