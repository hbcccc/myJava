package org.example.withdao.controller;

import org.example.withdao.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/department/demo")
    public String demo(){
        System.out.println(departmentService);
        return "demo";
    }
}
