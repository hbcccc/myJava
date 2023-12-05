package com.example.spring03employeeproject.controller;

import com.example.spring03employeeproject.dao.DepartmentDao;
import com.example.spring03employeeproject.dao.EmployeeDao;
import com.example.spring03employeeproject.pojo.Department;
import com.example.spring03employeeproject.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    public EmployeeDao employeeDao;
    @Autowired
    public DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAllEmployee();
        model.addAttribute("emps", employees);
        return "/emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getAllDepartments();
        departments.forEach(System.out::println);
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.printf("employe===>"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model){
        System.out.printf("json update emp=======>id: "+id);
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getAllDepartments();
//        System.out.println(employee);
        model.addAttribute("depts", departments);
        return "emp/update";
    }

    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        System.out.println("update emp ===>"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.deleteEmployee(id);
        return "redirect:/emps";
    }
}

// put: update;
//post: add;
//get: get;
//delete: delete;
