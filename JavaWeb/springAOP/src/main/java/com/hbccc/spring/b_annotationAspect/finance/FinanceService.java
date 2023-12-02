package com.hbccc.spring.b_annotationAspect.finance;

import com.hbccc.spring.b_annotationAspect.component.Log;
import org.springframework.stereotype.Component;

@Component
public class FinanceService {
    public void addMoney(double money) {
        System.out.println("FinanceService 收钱 === " + money);
    }

    @Log
    public double subtractMoney(double money) {
        System.out.println("FinanceService 付钱 === " + money);
        return money;
    }

    public double getMoneyById(String id) {
        System.out.println("FinanceService 查询账户，id为" + id);
        return Math.random();
    }
}