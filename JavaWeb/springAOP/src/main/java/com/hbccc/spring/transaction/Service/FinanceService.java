package com.hbccc.spring.transaction.Service;

import com.hbccc.spring.transaction.Aspect.Transactional;
import com.hbccc.spring.transaction.Dao.FinanceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinanceService {

    @Autowired
    FinanceDao financeDao;

    @Transactional
    public void transfer(Long source, Long target, int money) {
        financeDao.subtractMoney(source, money);
        int i = 1/ 0;
        financeDao.addMoney(target, money);
    }
}
