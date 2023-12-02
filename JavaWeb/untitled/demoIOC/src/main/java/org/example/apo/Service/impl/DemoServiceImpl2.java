package org.example.apo.Service.impl;


import org.example.apo.Dao.DemoDao;
import org.example.apo.Service.DemoService;
import org.example.apo.factory.BeanFactory;

import java.util.List;

public class DemoServiceImpl2 implements DemoService {
    DemoDao demoDao = (DemoDao) BeanFactory.getBean("demoDao");
    @Override
    public List<String> findAll() {
        System.out.println("demoserviceImpl 2");
        return demoDao.findAll();
    }

    @Override
    public int add(String userId, int points) {
        return points;
    }

    @Override
    public int sub(String userId, int points) {
        return points;
    }

    @Override
    public int mul(String userId, int points) {
        return points;
    }

    @Override
    public int div(String userId, int points) {
        return points;
    }
}
