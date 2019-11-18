package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.mybatis.OrderDao;
import com.example.springbootdemo.mybatis.OrderDetailDao;
import com.example.springbootdemo.pojo.Order;
import com.example.springbootdemo.service.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderServices {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    @Transactional
    public int addOrder(Order order) {
        int ans = 0;
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
