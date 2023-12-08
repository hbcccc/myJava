package com.example.spring07shirospringboot.service.user;

import com.example.spring07shirospringboot.pojo.User;

public interface UserService {
    User getUserById(int id);
    User getUserByName(String name);
    String addUser(User user);

}
