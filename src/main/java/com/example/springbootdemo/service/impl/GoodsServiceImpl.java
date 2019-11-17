package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.mybatis.GoodsDao;
import com.example.springbootdemo.mybatis.GoodsTypeDao;
import com.example.springbootdemo.pojo.Goods;
import com.example.springbootdemo.service.GoodsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsServices {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> getGoodsList(Goods goods,String status) {
        List<Goods> goodsList = null;
        try{
            goodsList = goodsDao.selectGoodsListAll(goods,status);
        }catch (Exception e){
            e.printStackTrace();
        }
        return goodsList;
    }

    @Override
    public Goods getGoods(Integer goodId) {
        Goods goods = null;
        try{
            goods = goodsDao.selectGoods(goodId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return goods;
    }


    @Override
    public int addGoods(Goods goods) {
        int ans = 0;
        try{
            ans = goodsDao.insertGoods(goods);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ans;
    }

    @Override
    public int updateGoods(Goods goods) {
        int ans =0;
        try{
            ans = goodsDao.updateGoods(goods);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ans;
    }
}
