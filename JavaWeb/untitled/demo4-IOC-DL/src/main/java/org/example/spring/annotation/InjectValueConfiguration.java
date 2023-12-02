package org.example.spring.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.example.spring.annotation.Bean")
@PropertySource("annotationIOC/attributeInject/red.properties")
public class InjectValueConfiguration {
}
