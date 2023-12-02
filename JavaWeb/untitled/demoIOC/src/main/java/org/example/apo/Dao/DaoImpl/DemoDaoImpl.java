package org.example.apo.Dao.DaoImpl;



import org.example.apo.Dao.DemoDao;

import java.util.Arrays;
import java.util.List;

public class DemoDaoImpl implements DemoDao {
    @Override
    public List<String> findAll() {
        return Arrays.asList(new String[]{"12","34","56"});
    }
}
