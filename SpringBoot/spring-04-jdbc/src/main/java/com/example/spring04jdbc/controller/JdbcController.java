package com.example.spring04jdbc.controller;

import com.example.spring04jdbc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
public class JdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/user")
    public List<User> userList(){
        StringBuffer sb = new StringBuffer();
        sb.append("select * from test");
         List<User> users = jdbcTemplate.query(sb.toString(), new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.name = rs.getString("name");
                user.age = rs.getInt("age");
                return  user;
            }
        });
        return users;
    }
}
