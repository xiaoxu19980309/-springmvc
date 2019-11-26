package com.example.springbootdemo.service;

import com.example.springbootdemo.pojo.ShoppingCar;

import java.util.List;

public interface ShoppingCarServices {
    int addToCar(ShoppingCar shoppingCar);
    int deleteShoppingCar(Integer id);
    int deleteShoppingCarList(List<Integer> idList);
    List<ShoppingCar> getShoppingCar(Integer UserId);
}
