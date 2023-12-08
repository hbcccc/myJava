package com.example.spring08swagger.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@EnableSwagger2
@Configuration
@Profile("test")
public class SwaggerConfig  {
    @Bean
    public Docket api(Environment environment){
        Profiles profiles = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("HelloGroup")
                .enable(flag)
                .select()
                //RequestHandlerSelectors用于配置要扫描的接口的方式
                    //basePackage为扫描指定的包下的接口
                    //none、any如名所说
                    //withClassAnnotation： 根据类上的注解来筛选扫描， eg： RestController.class
                    //withMethodAnnotation： 根据方法上的注解来筛选扫描， eg： GetMapping.class
                .apis(RequestHandlerSelectors.basePackage("com.example.spring08swagger.controller"))
                //.paths() 用于过滤路径, 比如有UserController， HelloController，
                //输入参数"/user/**"， 则只有url前缀有"/user"的请求才会被扫描到swagger
                .paths(PathSelectors.ant("/hello/**"))
                .build();
    }

    @Bean
    public Docket api2(Environment environment){
        Profiles profiles = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("UserGroup")
                .enable(flag)
                .select()
                //RequestHandlerSelectors用于配置要扫描的接口的方式
                //basePackage为扫描指定的包下的接口
                //none、any如名所说
                //withClassAnnotation： 根据类上的注解来筛选扫描， eg： RestController.class
                //withMethodAnnotation： 根据方法上的注解来筛选扫描， eg： GetMapping.class
                .apis(RequestHandlerSelectors.basePackage("com.example.spring08swagger.controller"))
                //.paths() 用于过滤路径, 比如有UserController， HelloController，
                //输入参数"/user/**"， 则只有url前缀有"/user"的请求才会被扫描到swagger
                .paths(PathSelectors.ant("/user/**"))
                .build();
    }


    private ApiInfo apiInfo(){
        Contact contact = new Contact("hbc",
                "https://ieeexplore.ieee.org/author/37089935525",
                "1242582816@qq.com");

        return new ApiInfo("hbcPracSwagger",
                "this is a small step to offers",
                "v1.0",
                "http://192.168.2.144",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
                );
    }

}

