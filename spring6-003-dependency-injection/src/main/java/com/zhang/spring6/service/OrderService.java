package com.zhang.spring6.service;

import com.zhang.spring6.dao.OrderDao;

public class OrderService {
    OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void insert(){
        orderDao.save();
    }

}
