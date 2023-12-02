package org.example.spring.configuration.c_conditional.selector;

import org.example.spring.configuration.c_conditional.component.Bar;
import org.example.spring.configuration.c_conditional.config.BarConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class BarImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Bar.class.getName(), BarConfiguration.class.getName()};
        //这里根据Bar.class.getName()创建了一个bean
        //之后根据BarConfiguration.class.getName()， 这个配置里内又创建了名为bbbar的Bar类型bean
    }
}
