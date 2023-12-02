package org.example.spring.configuration.b_profile.anno;

import org.example.spring.configuration.b_profile.selector.BarImportSelector;
import org.example.spring.configuration.b_profile.config.BartenderConfiguration;
import org.example.spring.configuration.b_profile.component.Boss;
import org.example.spring.configuration.b_profile.registrar.WaiterRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({Boss.class, BartenderConfiguration.class, BarImportSelector.class, WaiterRegistrar.class})
public @interface EnableTavern {
}
