package com.hbccc.spring.b_annotationAspect;

import com.hbccc.spring.b_annotationAspect.finance.FinanceService;
import com.hbccc.spring.b_annotationAspect.order.OderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@Configuration
@ComponentScan("com.hbccc.spring.b_annotationAspect")
@EnableAspectJAutoProxy
public class annoAspectApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(annoAspectApplication.class);
        FinanceService financeService = ctx.getBean(FinanceService.class);
        financeService.addMoney(123.45);
        financeService.subtractMoney(543.21);
        financeService.getMoneyById("hbc");
        OderService orderService = ctx.getBean(OderService.class);
        orderService.deleteOrderById("hbccc");
    }
}
