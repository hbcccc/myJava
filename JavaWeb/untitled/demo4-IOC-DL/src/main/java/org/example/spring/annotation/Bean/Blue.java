package org.example.spring.annotation.Bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Blue {
    @Value("blue-value-anno")
    private String name;
    @Value("0")
    private Integer order;

    @Override
    public String toString() {
        return "Blue{" + "name='" + name + '\'' + ", order=" + order + '}';
    }
}
