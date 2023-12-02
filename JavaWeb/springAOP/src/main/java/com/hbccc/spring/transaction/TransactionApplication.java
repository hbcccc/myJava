package com.hbccc.spring.transaction;

import com.hbccc.spring.transaction.Service.FinanceService;
import com.hbccc.spring.transaction.configuration.TransactionAspectConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TransactionApplication {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                TransactionAspectConfiguration.class);
        FinanceService financeService = ctx.getBean(FinanceService.class);
        financeService.transfer(1L, 2L, 100);
    }
}
