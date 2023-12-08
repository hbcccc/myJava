package com.example.spring07shirospringboot;

import com.example.spring07shirospringboot.pojo.User;
import com.example.spring07shirospringboot.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@SpringBootTest
class Spring07ShiroSpringBootApplicationTests {

//    @Autowired
//    JdbcTemplate jdbcTemplate;
//    @Test
//    void contextLoads() {
//        ArrayList<User> users = (ArrayList<User>) jdbcTemplate.query("select * from testuser where id= 1", new RowMapper<User>() {
//            @Override
//            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//                User user1 = new User();
//                user1.setId(rs.getInt("id"));
//                user1.setName(rs.getString("name"));
//                user1.setPwd(rs.getString("pwd"));
//                return  user1;
//            }
//        });
//
//        System.out.println(users.get(0));
//    }


    @Autowired
    UserService userService;
    @Test
    void contextLoads(){
        User user = userService.getUserById(2);
        User user1 = userService.getUserByName("hbc");
        System.out.println(user1);
        System.out.println(user);
    }

}
