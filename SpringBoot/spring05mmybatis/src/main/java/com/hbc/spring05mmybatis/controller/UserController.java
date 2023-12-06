package com.hbc.spring05mmybatis.controller;

import com.hbc.spring05mmybatis.mapper.UserMapeer;
import com.hbc.spring05mmybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserMapeer userMapeer;
    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userMapeer.getUserById(id);
    }

    @GetMapping("/addUser")
    public String setUser(User user){
        userMapeer.addUser(user);
        return "ok";
    }


}
