package org.example.spring.configuration.g_enablejdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.example.spring.configuration.g_enablejdbc.config.EnableJdbc;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@EnableJdbc
@PropertySource("enablejdbc/jdbc.properties")
public class EnableJdbcApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EnableJdbcApplication.class);
        String[] dataSourceNames =  ctx.getBeanNamesForType(DataSource.class);
        for(String dataSourceName: dataSourceNames){
            DruidDataSource dataSource = (DruidDataSource) ctx.getBean(dataSourceName);
            System.out.println(dataSource.getDriverClassName());
        }


    }
}
