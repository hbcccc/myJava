package apo.factory;

import apo.Dao.DemoDao;
import apo.Service.DemoService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private  static Properties properties;
    private  static Map<String, Object> beanMap = new HashMap<>();
    static {
        properties = new Properties();
        try {
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("web.WEB-INF.classes.apoDemoService.properties"));
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
                        beanMap.put(beanName, bean);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException("BeanFactory hs no ["+beanName+"] bean!");
                    } catch (InstantiationException e) {
                        throw new RuntimeException("[" + beanName + "] instantiation error!", e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("[" + beanName + "] instantiation error!", e);
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
