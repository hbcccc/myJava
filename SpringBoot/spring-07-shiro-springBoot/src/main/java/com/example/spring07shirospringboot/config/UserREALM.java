package com.example.spring07shirospringboot.config;

import com.example.spring07shirospringboot.pojo.User;
import com.example.spring07shirospringboot.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserREALM extends AuthorizingRealm {
    @Autowired
    UserService userService;

    UserREALM(){
        System.out.println("userRealm is created");
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("执行了=>授权");
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addStringPermission("user:add");
//        return info;
        return  null;
    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了=>认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.getUserByName(token.getUsername());

         if(user == null) //没在数据库找到该用户
            return  null;



        //密码认证，由shiro来去做. 此处传递的是数据库中user的密码
        return new SimpleAuthenticationInfo("", user.getPwd() ,"");
    }
}
