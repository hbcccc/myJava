package org.example.spring.configuration.c_conditional;


import org.example.spring.configuration.c_conditional.component.Bartender;
import org.example.spring.configuration.c_conditional.config.TavernConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.stream.Stream;

public class TavernAplication {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TavernConfiguration.class);
//        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
//        System.out.println("--------------------------");
//
//        //如果Profile标注了“city”，此时默认profile项为default，
//        // 不匹配city，因此BartenderConfiguration配置类没有进行bartender注入
//        Map<String, Bartender> bartenders = ctx.getBeansOfType(Bartender.class);
//        bartenders.forEach((name, bartender) -> System.out.println(bartender));


        //如果想通过代码编程使得ctx的profile属性改变，同时影响bean的创建，
        // 那么必须在ctx完成初始化（具体而言是refresh操作）操作前完成属性修改操作

        //如下，相比直接传入配置类名（此时ctx会自动完成初始化，那一切就晚了）
        //先修改ctx属性，之后手工注册配置类和refresh，完成ctx初始化动作
        //此时，ctx的profile设为city，能够注册Bartender
        //对于实战而言，可能是有些组件我们希望只有测试时使用（如测试数据源），
        // 而部署后，我们切换了ctx的profile为生产环境模式，所以不激活或激活特定bean
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("city");
        ctx.register(TavernConfiguration.class);
        ctx.refresh();

        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("--------------------------");

        Map<String, Bartender> bartenders = ctx.getBeansOfType(Bartender.class);
        bartenders.forEach((name, bartender) -> System.out.println(bartender));



    }
}
