package org.example.spring.annotation.e_propertysource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.example.spring.annotation.e_propertysource.bean")
@PropertySource("classpath:propertysource/jdbc.xml")
public class JdbcXmlPropertiesConfiguration {
}
