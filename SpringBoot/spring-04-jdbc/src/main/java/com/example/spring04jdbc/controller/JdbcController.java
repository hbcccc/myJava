package com.example.spring04jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;

}
