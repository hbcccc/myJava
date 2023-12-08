package com.example.spring07shirospringboot.service.user;

import com.example.spring07shirospringboot.mapper.UserMapper;
import com.example.spring07shirospringboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public String addUser(User user) {
        userMapper.addUser(user);
        return "ok";
    }
}
