package com.example.spring03employeeproject.dao;

import com.example.spring03employeeproject.pojo.Department;
import com.example.spring03employeeproject.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {
    @Autowired
    DepartmentDao departmentDao;
    private static Map<Integer, Employee> employees = null;
    static {
        employees = new HashMap<>();
        employees.put(0, new Employee(0, "bocheng0","a123@qq.com", 1, new Department(0, "教学部")));
        employees.put(1, new Employee(1, "bocheng1","b123@qq.com", 1, new Department(1, "市场部")));
        employees.put(2, new Employee(2, "bocheng2","c123@qq.com", 0, new Department(2, "运营部")));
        employees.put(3, new Employee(3, "bocheng3","d123@qq.com", 0, new Department(0, "教学部")));

    }

    private static  Integer initId = 1006;

    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }
    public Collection<Employee> getAllEmployee(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void deleteEmployee(Integer id){
        employees.remove(id);
    }

}
