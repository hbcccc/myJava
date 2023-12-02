package org.example.spring.configuration.c_conditional.anno;

import org.example.spring.configuration.c_conditional.component.Boss;
import org.example.spring.configuration.c_conditional.config.BartenderConfiguration;
import org.example.spring.configuration.c_conditional.registrar.WaiterRegistrar;
import org.example.spring.configuration.c_conditional.selector.BarImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({Boss.class,BartenderConfiguration.class, BarImportSelector.class, WaiterRegistrar.class})
public @interface EnableTavern {
}
