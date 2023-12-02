package org.example.withdao.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

@Configuration
@Import(JdbcConfiguration.class)
@ComponentScan(value = "org.example.withdao",
    excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)})
public class RootConfiguration {
}
