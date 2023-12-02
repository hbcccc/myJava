package org.example.spring.basic_dl.a_quickstart_byType;

import org.example.spring.basic_dl.bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.example.spring.basic_dl.a_quickstart_byType.DAO.demoDao;
public class QuickstartBTypeApplication {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("basic_dl/quickstart-bytype.xml");
        Person person =  factory.getBean(Person.class);
        System.out.println(person);

        //依赖查找，因为demoOracleDao类已经在xml注册为bean，所以能通过getBean()查找到，并创建实例。
        demoDao demo = factory.getBean(demoDao.class);
        System.out.println(demo.getList());


    }
}
