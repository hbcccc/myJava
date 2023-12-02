package org.example.spring.basic_dl.c_oftype.DAO;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private static  Properties properties;
    private static Map<String, Object> beanMap = new HashMap<>();
    static {
        properties = new Properties();
        try {
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("factory.properties"));
        } catch (IOException e) {
            throw new ExceptionInInitializerError("BeanFactory initialize error, cause: " + e.getMessage());
        }

    }
    public static Object getBean(String beanName){
        if(beanMap.containsKey(beanName))
            return beanMap.get(beanName);
        synchronized (BeanFactory.class){
            if(!beanMap.containsKey(beanName)){
                try {
                    Class<?> beanClass = Class.forName(properties.getProperty(beanName));
                    System.out.println("beanclass is:"+beanClass.getName());
                    beanMap.put(beanName, beanClass.newInstance());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException("BeanFactory has no ["+beanName+"] bean!", e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return beanMap.get(beanName);
    }

}

