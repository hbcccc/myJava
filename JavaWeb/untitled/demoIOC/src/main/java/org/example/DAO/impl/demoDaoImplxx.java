package org.example.DAO.impl;
import org.example.DAO.demoDao;

import java.util.Arrays;
import java.util.List;

public class demoDaoImplxx implements demoDao{
    public List<String> getList(){
        return Arrays.asList("aa", "bb", "cc");
    }
}
