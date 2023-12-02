package org.example.spring.annotation.Bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Red {
    @Value("${red.name}")
    private String name;
    @Value("${red.order}")
    private Integer order;

    @Override
    public String toString() {
        return "Blue{" + "name='" + name + '\'' + ", order=" + order + '}';
    }
}
