package org.example.a_quickstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoDController {
    @RequestMapping("/demo")
    public String demo(){
        return "demo";
    }
}
