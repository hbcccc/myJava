package org.example.spring.basic_dl.a_quickstart_byType.DAO.impl;
import org.example.spring.basic_dl.a_quickstart_byType.DAO.demoDao;

import java.util.Arrays;
import java.util.List;

public class demoDaoImplxx implements demoDao{
    public List<String> getList(){
        return Arrays.asList("aa", "bb", "cc");
    }
}
