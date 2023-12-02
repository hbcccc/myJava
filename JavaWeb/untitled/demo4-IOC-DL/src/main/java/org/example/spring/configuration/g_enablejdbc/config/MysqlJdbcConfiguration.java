package org.example.spring.configuration.g_enablejdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.example.spring.configuration.g_enablejdbc.annotation.ConditionalOnclassName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConditionalOnclassName("com.mysql.jdbc.Driver")
public class MysqlJdbcConfiguration extends AbstractJdbcConfiguration{
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        return dataSource;
    }
}
