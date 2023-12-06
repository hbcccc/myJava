package com.hbc.spring05shiro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class
SecurityConfig extends  WebSecurityConfigurerAdapter{

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        //首页所有人可以访问，但功能也只有对应有权限的人才能访问
        http.authorizeHttpRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        //没权限的默认跳转至登陆页面
        http.formLogin();
        http.logout().logoutSuccessUrl("/");

    }


    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);

        //以下数据正常应该是从数据库读，但现在从内存里读。
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("hbc")
                .password(new BCryptPasswordEncoder().encode( "123456"))
                .roles("vip2", "vip3")
                .and()
                .withUser("root")
                .password(new BCryptPasswordEncoder().encode( "123456"))
                .roles("vip1","vip2", "vip3")
                .and()
                .withUser("guest")
                .password(new BCryptPasswordEncoder().encode( "123456"))
                .roles("vip1");

    }
}
