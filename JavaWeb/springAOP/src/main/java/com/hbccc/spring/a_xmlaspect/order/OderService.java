package com.hbccc.spring.a_xmlaspect.order;

import java.util.List;

public interface OderService {
    void createOrder();

    void deleteOrderById(String id);

    String  getOrderById(String id);

    List<String> findAll();
}
