package com.example.springbootdemo.service;

import com.example.springbootdemo.pojo.Goods;

import java.util.List;

public interface GoodsServices {
    List<Goods> getGoodsList(Goods goods,String status);
    Goods getGoods(Integer goodId);
    int addGoods(Goods goods);
    int updateGoods(Goods goods);
}
