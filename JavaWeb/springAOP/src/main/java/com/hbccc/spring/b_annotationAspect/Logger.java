package com.hbccc.spring.b_annotationAspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
    @Before("execution(public * com.hbccc.spring.b_annotationAspect.finance.FinanceService.addMoney(double))")
    public void beforePrint() {
        System.out.println("Logger beforePrint run ......");
    }

    @After("@annotation(com.hbccc.spring.b_annotationAspect.component.Log)")
    public void afterPrint() {
        System.out.println("Logger afterPrint run ......");
    }

    public void afterReturningPrint() {
        System.out.println("Logger afterReturningPrint run ......");
    }

    public void afterThrowingPrint() {
        System.out.println("Logger afterThrowingPrint run ......");
    }

//    @Around("execution(public * com.hbccc.spring.b_annotationAspect.finance.FinanceService.addMoney(double))")
    @Around("defaultPointcut()")
    public Object aroundPrint(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Logger aroundPrint before run ......");
        try {

            Object retVal = joinPoint.proceed();
            System.out.println("Logger aroundPrint afterReturning run ......");
            return retVal;
        } catch (Throwable e) {
            System.out.println("Logger aroundPrint afterThrowing run ......");
            throw e;
        } finally {
            System.out.println("Logger aroundPrint after run ......");
        }
    }

    @Pointcut("execution(public * com.hbccc.spring.b_annotationAspect.*.*.*(String))")
    public  void defaultPointcut(){

    }
}
