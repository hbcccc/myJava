package com.example.spring07shirospringboot.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    // ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager());
        System.out.println("====>from shiroBean: mannager id: "+bean.getSecurityManager());

        /*
        * anno
        * authc
        * user
        * perms
        * role
        * */



        Map<String, String> filterMap = new HashMap<>();

        //添加shiro的内置过滤器,完成页面拦截
//        filterMap.put("/user/add", "authc");
//        filterMap.put("/user/update", "authc");
//        bean.setFilterChainDefinitionMap(filterMap);

        //授权
        filterMap.put("/user/add", "perms[user:add]");
        filterMap.put("/user/*", "authc");
        bean.setFilterChainDefinitionMap(filterMap);



        //设置未认证时的跳转登陆页面url
        bean.setLoginUrl("/toLogin");

        //设置未授权时的跳转页面
        bean.setUnauthorizedUrl("/noauth");

        return  bean;
    }



    //DefaultWebSecurityManager 管用户的
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userREALM());
        System.out.println("realms sizE:"+ manager.getRealms().size());
        System.out.println("=======>from manager: "+((ArrayList) manager.getRealms()).get(0));
        System.out.println("manager id: "+ manager);
        return manager;
    }


    //realm, 管数据的
    @Bean
    public UserREALM userREALM(){
        UserREALM userREALM =  new UserREALM();
        System.out.println("========>from userREALM: "+ userREALM);
        return  userREALM;
    }

}
