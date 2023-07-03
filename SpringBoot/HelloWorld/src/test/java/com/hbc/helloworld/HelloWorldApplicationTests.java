package com.hbc.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloWorldApplicationTests {
	@Autowired
	Person p1;

	@Test
	void contextLoads() {
		System.out.println(p1);

	}



}
