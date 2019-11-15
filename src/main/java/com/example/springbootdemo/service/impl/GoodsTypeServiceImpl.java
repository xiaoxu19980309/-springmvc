package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.mybatis.UserDao;
import com.example.springbootdemo.pojo.GoodsType;
import com.example.springbootdemo.service.GoodsTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeServices {

    @Autowired
    private UserDao userDao;

    @Override
    public int addGoodsType(GoodsType goodsType) {
        return 0;
    }

    @Override
    public List<GoodsType> queryType() {
        return null;
    }

    @Override
    public int deleteGoodsType() {
        return 0;
    }
}
