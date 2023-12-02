package com.example.spring03employeeproject.dao;

import com.example.spring03employeeproject.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    //模拟数据库链接
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<>();
        departments.put(0, new Department(0, "教学部"));
        departments.put(1, new Department(1, "市场部"));
        departments.put(2, new Department(2, "运营部"));
    }

    public Collection<Department> getAllDepartments(){
        return  departments.values();
    }

    public Department getDepartmentById(Integer id){
        return  departments.get(id);
    }
}
