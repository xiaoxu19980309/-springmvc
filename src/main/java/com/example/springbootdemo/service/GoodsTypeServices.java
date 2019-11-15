package com.example.springbootdemo.service;

import com.example.springbootdemo.pojo.GoodsType;

import java.util.List;

public interface GoodsTypeServices {
    int addGoodsType(GoodsType goodsType);
    List<GoodsType> queryType();
    int deleteGoodsType();
}
