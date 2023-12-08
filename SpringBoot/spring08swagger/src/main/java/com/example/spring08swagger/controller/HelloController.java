package com.example.spring08swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello from HelloController!";
    }

    @ApiOperation("Hello2控制类mapping")
    @GetMapping("/hello2/{msg}")
    public String hello2(@PathVariable("msg") @ApiParam("要打印的消息") String msg){
            return  "from hello2: " + msg;
    }
}
