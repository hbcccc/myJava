package com.example.spring07async.controller;

import com.example.spring07async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    AsyncService asyncService;
    @RequestMapping("/hellox")
    @ResponseBody
    public String hello(){
        asyncService.hello();
        return "OK";
    }
}
