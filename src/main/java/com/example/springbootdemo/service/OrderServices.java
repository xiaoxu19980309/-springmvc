package com.example.springbootdemo.service;

import com.alibaba.fastjson.JSONArray;
import com.example.springbootdemo.pojo.Goods;
import com.example.springbootdemo.pojo.Order;
import com.example.springbootdemo.pojo.OrderDetail;

import java.util.List;

public interface OrderServices {
    int addOrder(Order order, JSONArray list);
    List<Order> getOrdersList(Integer user_id);
    List<OrderDetail> getOrderDetails(String order_id);
}
