package org.example.withdao.controller;

import org.example.withdao.dao.DepartmentDao;
import org.example.withdao.entity.Department;
import org.example.withdao.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/department")
public class RestfulDepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/{id}")
    @ResponseBody
    public Department findById(@PathVariable("id") String id){
        return departmentService.findById(id);
    }


    @PostMapping("/")
    public void save(Department department) {
        departmentService.save(department);
    }

    @PutMapping("/{id}")
    public void update(Department department, @PathVariable("id") String id) {
        // update .....
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        departmentService.deleteById(id);
    }
}
