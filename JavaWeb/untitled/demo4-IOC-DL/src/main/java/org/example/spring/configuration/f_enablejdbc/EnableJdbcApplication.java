package org.example.spring.configuration.f_enablejdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableJdbc
public class EnableJdbcApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EnableJdbcApplication.class);
        String[] dataSourceNames =  ctx.getBeanNamesForType(DataSource.class);
        for(String dataSourceName: dataSourceNames){
            DruidDataSource dataSource = (DruidDataSource) ctx.getBean(dataSourceName);
            System.out.println(dataSource.getUrl());
        }


    }
}
