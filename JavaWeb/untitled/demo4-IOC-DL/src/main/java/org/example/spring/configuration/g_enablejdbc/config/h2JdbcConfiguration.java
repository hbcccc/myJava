package org.example.spring.configuration.g_enablejdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.example.spring.configuration.g_enablejdbc.annotation.ConditionalOnclassName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
@ConditionalOnclassName("org.h2.Driver")
public class h2JdbcConfiguration extends AbstractJdbcConfiguration{
    @Bean
    public DataSource h2DataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        return dataSource;
    }
}
