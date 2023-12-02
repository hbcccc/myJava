package org.example.withdao.controller;

import org.example.withdao.entity.Department;
import org.example.withdao.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JsonDepartmentController {
    @Autowired
    DepartmentService departmentService;
    @PostMapping("/department/saveJson")
    @ResponseBody
    public  void saveJson(@RequestBody Department department){
        System.out.println(department);
    }

    @GetMapping("/department/listJson")
    @ResponseBody
    public List<Department> listJson(){
        List<Department> departments = departmentService.findDepartments(null);
        return departments;
    }
}
