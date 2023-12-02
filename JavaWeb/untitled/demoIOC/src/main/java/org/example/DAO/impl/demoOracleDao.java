package org.example.DAO.impl;

import org.example.DAO.demoDao;

import java.util.Arrays;
import java.util.List;

public class demoOracleDao implements demoDao {

    public List<String> getList() {
        return Arrays.asList("oracle", "oracle", "oracle");
    }
}
