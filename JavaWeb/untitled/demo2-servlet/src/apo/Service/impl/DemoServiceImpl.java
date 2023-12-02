package apo.Service.impl;

import apo.Dao.DemoDao;
import apo.Service.DemoService;
import apo.factory.BeanFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoServiceImpl implements DemoService {
    DemoDao demoDao = (DemoDao) BeanFactory.getBean("demoDao");
    @Override
    public List<String> findAll() {
        System.out.println("demoserviceImpl 1");
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
