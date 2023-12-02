package org.example.spring.basic_dl.c_oftype.DAO.impl;



import org.example.spring.basic_dl.c_oftype.DAO.demoDao;

import java.util.Arrays;
import java.util.List;

public class demoOracleDao implements demoDao {

    public List<String> getList() {
        return Arrays.asList("oracle", "oracle", "oracle");
    }
}
