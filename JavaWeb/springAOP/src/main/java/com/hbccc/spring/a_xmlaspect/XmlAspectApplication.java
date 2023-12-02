package com.hbccc.spring.a_xmlaspect;

import com.hbccc.spring.a_xmlaspect.finance.FinanceService;
import com.hbccc.spring.a_xmlaspect.order.OderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlAspectApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop/xmlaspect.xml");
        FinanceService financeService = ctx.getBean(FinanceService.class);
        financeService.addMoney(123.45);
        financeService.subtractMoney(543.21);
        financeService.getMoneyById("hbc");
        OderService orderService = ctx.getBean(OderService.class);
        orderService.deleteOrderById("hbccc");
    }
}
