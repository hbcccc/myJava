package org.example.spring.configuration.f_enablejdbc;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnClassNameConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata){
        //传入的Jdbcleixing
        String className = (String) metadata.getAnnotationAttributes(ConditionalOnclassName.class.getName()).get("value");
        try {
            Class.forName(className);
            return  true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
