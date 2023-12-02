package org.example.Service.impl;
import org.example.DAO.BeanFactory;
import org.example.Service.demoService;
import org.example.DAO.demoDao;

import java.util.List;

public class demoServiceImpl implements demoService {
    demoDao daoimp = (demoDao)BeanFactory.getBean("DAOIMPLEMENT");

    public demoServiceImpl(){
        for(int i = 0; i < 10; i++)
            System.out.println(BeanFactory.getBean("DAOIMPLEMENT"));
    }

    public List<String> getList(){
        return daoimp.getList();
    }
}
