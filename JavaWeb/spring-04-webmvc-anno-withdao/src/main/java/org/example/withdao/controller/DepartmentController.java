package org.example.withdao.controller;

import org.example.withdao.entity.Department;
import org.example.withdao.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/demo")
    public String demo(){
        System.out.println(departmentService);
        return "demo";
    }

//    @RequestMapping("/list")
//    public String list(HttpServletRequest request) {
//        request.setAttribute("deptList", departmentService.findDepartments(null));
//        return "dept/deptList";
//    }
//
//
//    @RequestMapping("/list")
//    public ModelAndView list(ModelAndView mav) {
//        mav.addObject("deptList", departmentService.findDepartments((null)));
//        mav.setViewName("dept/deptList");
//        return mav;
//    }


//    @RequestMapping("/list")
//    public  String list(HttpServletRequest request){
//        String name = request.getParameter("name");
//        request.setAttribute("deptList", departmentService.findDepartmentsByName(name));
//        return "dept/deptList";
//    }
//
//    @RequestMapping("/list")
//    public  String list(String name){
//        request.setAttribute("deptList", departmentService.findDepartmentsByName(name));
//        return "dept/deptList";
//    }


    @RequestMapping("/list")
    public  String list(Department department,  @ModelAttribute("name") String name){
        request.setAttribute("deptList", departmentService.findDepartments(department));
        return "dept/deptList";
    }

    @RequestMapping("/delete")
    public String delete(String id){
        departmentService.deleteById(id);
        return "redirect:/department/list";
    }
    @RequestMapping("/edit")
    public String edit(HttpServletRequest request, String id) {
        request.setAttribute("dept", departmentService.findById(id));
        return "dept/deptInfo";
    }

    @RequestMapping("/save")
    public String save(@ModelAttribute("dept") Department department) {
        System.out.println(department);
//        departmentService.save(department);
        if(department.getName().length() > 10){
            System.out.println("too long! the department name!");
            return "dept/deptInfo";
        }

        return "redirect:/department/list";
    }
}
