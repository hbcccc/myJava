package org.example.spring.configuration.g_enablejdbc.Component;

import org.example.spring.configuration.g_enablejdbc.config.AbstractJdbcConfiguration;
import org.example.spring.configuration.g_enablejdbc.config.EnableJdbc;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.List;

public class JdbcConfigSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //SpringFactoriesLoader 会读取META-INF下的spring.factories文件，
        // 根据给定的key（factoryName）（eg： EnableJdbc.class的全称名），
        // 寻找对应的value（MysqlConfig，h2Config）。

        //总的来说，会根据外部配置，来读取需要加载的类名。然后返回给@Import中，就相当于
        // @Import（MysqlConfiguration.class）啦
        List<String> configClassNames = SpringFactoriesLoader
                .loadFactoryNames(EnableJdbc.class, this.getClass().getClassLoader());
        return ((List<?>) configClassNames).toArray(new String[0]);
    }
}