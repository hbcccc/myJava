package com.hbccc.spring.transaction.Aspect;

import com.hbccc.spring.transaction.Dao.JdbcUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.sql.Connection;
@Component
@Aspect
public class TransactionAspect {
    @Around("@annotation(com.hbccc.spring.transaction.Aspect.Transactional)")
    public Object doWithTransaction(ProceedingJoinPoint joinPoint) throws Throwable{
        Connection connection = JdbcUtils.getConnection();
        connection.setAutoCommit(false);
        try {
            System.out.println("is aspecting method: "+ joinPoint.getSignature());
            Object retval = joinPoint.proceed();
            connection.commit();
            return  retval;
        }catch (Throwable e){
            connection.rollback();
            throw e;
        }finally {
            JdbcUtils.remove();
        }

    }
}
