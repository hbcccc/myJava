package org.example.spring.basic_di.a_quickstart_set;

import org.example.spring.basic_di.a_quickstart_set.Bean.Cat;
import org.example.spring.basic_di.a_quickstart_set.Bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuckstartInjectBySetXmlApplication {


    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("basic_di/inject-set.xml");
        Person person = factory.getBean(Person.class);
        Cat    cat    = factory.getBean(Cat.class);
        System.out.println(person);
        System.out.println(cat);

    }
}
