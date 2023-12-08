package com.example.spring07shirospringboot.mapper;

import com.example.spring07shirospringboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User getUserById(Integer id);
    int addUser(User user);

    User getUserByName(String name);
}
