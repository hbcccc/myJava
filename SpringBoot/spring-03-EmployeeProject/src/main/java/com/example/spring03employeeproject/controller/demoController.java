package com.example.spring03employeeproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class demoController {
    @RequestMapping("/signin")
    public String signin(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         Model model, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }

        System.out.println("illege!!!!!!!!");
        model.addAttribute("msg", "用户名或者密码错误!");

         return  "sign-in";
    }
    @RequestMapping("")
    public String root(){
        return "sign-in";
    }

    @RequestMapping("/dash")
    public String dash(Model model){
        return  "dashboard";
    }
}
