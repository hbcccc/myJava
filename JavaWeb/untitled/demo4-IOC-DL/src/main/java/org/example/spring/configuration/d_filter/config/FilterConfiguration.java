package org.example.spring.configuration.d_filter.config;

import org.example.spring.configuration.d_filter.anno.Annimal;
import org.example.spring.configuration.d_filter.color.Color;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "org.example.spring.configuration.d_filter",
        excludeFilters  = {
            @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Annimal.class),
            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Color.class),
            @ComponentScan.Filter(type = FilterType.CUSTOM, value = GreenTypeFilter.class)
        }
//        ,excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Color.class)}
        ,includeFilters = {
            @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org.example.spring.configuration.d_filter.+Demo.+")
}
)
public class FilterConfiguration {
}
