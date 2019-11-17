package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.mybatis.ShoppingCarDao;
import com.example.springbootdemo.pojo.ShoppingCar;
import com.example.springbootdemo.service.ShoppingCarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCarServiceImpl implements ShoppingCarServices {
    @Autowired
    private ShoppingCarDao shoppingCarDao;

    @Override
    public int addToCar(ShoppingCar shoppingCar) {
        return 0;
    }
}
