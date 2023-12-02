package org.example.spring.basic_dl.c_oftype;

import org.example.spring.basic_dl.c_oftype.DAO.demoDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class ofTypeApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("basic_dl/quickstart-ofType.xml");
        Map<String, demoDao> beans = ctx.getBeansOfType(demoDao.class);
        beans.forEach((beanName, bean)->{
            System.out.println(beanName+" : " + bean.toString() +" : "+bean.getList());
        });
    }
}
