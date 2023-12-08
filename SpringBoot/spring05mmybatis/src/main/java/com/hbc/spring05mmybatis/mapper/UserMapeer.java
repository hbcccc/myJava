package com.hbc.spring05mmybatis.mapper;

import com.hbc.spring05mmybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapeer {
    public User getUserById(Integer id);
    public int addUser(User user);
}
