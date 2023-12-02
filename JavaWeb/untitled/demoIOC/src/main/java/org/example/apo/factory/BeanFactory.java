package org.example.apo.factory;



import org.example.apo.Dao.DemoDao;
import org.example.apo.Service.DemoService;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.*;

public class BeanFactory {
    private  static Properties properties;
    private  static Map<String, Object> beanMap = new HashMap<>();
    static {
        properties = new Properties();
        try {
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("apoDemoService.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static  Object getBean(String beanName){
        if(!beanMap.containsKey(beanName)){
            synchronized (BeanFactory.class){
                if(!beanMap.containsKey(beanName)){
                    try {
                        System.out.println("target className is:"+properties.getProperty(beanName));
                        Class<?> beanClazz = Class.forName(properties.getProperty(beanName));
                        Object bean = beanClazz.newInstance();
                        //检测是否存在代理类
                        //如果存在，则先创建InvocationHandler，相当于创建一对一的代理员，进行代理对象（原始bean）绑定，规定了代理的具体行为
                        //之后创建Proxy类，相当于完成了原始bean的封装。
                        String proxyAdvisorClassName = properties.getProperty(beanName+".proxy.class");

                        if(proxyAdvisorClassName != null && proxyAdvisorClassName.trim().length() > 0){
                            System.out.println("存在代理类："+proxyAdvisorClassName);
                            Class<?> proxyClass = Class.forName(proxyAdvisorClassName);
                            String[] methods = properties.getProperty(beanName+".proxy.methods").split(",");
                            System.out.println("存在代理方法："+Arrays.asList(methods).toString());
                            InvocationHandler proxyHandler = (InvocationHandler) proxyClass
                                    .getConstructors()[0].newInstance(bean, methods);
                            bean = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), proxyHandler);
                        }

                        beanMap.put(beanName, bean);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException("BeanFactory hs no ["+beanName+"] bean!");
                    } catch (InstantiationException e) {
                        throw new RuntimeException("[" + beanName + "] instantiation error!", e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("[" + beanName + "] instantiation error!", e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return  beanMap.get(beanName);

    }

    public static void main(String[] args) {
        DemoDao demoDao = (DemoDao) BeanFactory.getBean("demoDao");
        List<String> result  =  demoDao.findAll();
        System.out.println(result.toString());

        DemoService demoService = (DemoService) BeanFactory.getBean("demoService");
        result = demoService.findAll();
    }
}
