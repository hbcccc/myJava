package com.hbc.helloworld;

import com.hbc.helloworld.pojo.Cat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CatTest {
    @Autowired
    Cat cat;

    @Test
    void contextLoads(){
        System.out.println(cat);
    }

}
