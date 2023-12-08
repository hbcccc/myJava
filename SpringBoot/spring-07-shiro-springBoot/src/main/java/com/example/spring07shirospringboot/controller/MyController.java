package com.example.spring07shirospringboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @RequestMapping({"/", "/index"})
    public String toIndex(Model model){
        model.addAttribute("msg", "from controller");
        System.out.println("===================");
        return "indexx";
    }

    @RequestMapping("/user/add")
    public String add(){
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String update(){
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            //登陆
            subject.login(token);
            return "redirect:/";
        }catch (UnknownAccountException e){
            model.addAttribute("msg", "unknownAccount error !");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg", "incorrectPassWord error !");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/";
    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String noAuth(){
        return "未经授权，无法访问";
    }


}
