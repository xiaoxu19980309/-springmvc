package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.mybatis.GoodsTypeDao;
import com.example.springbootdemo.mybatis.UserDao;
import com.example.springbootdemo.pojo.GoodsType;
import com.example.springbootdemo.service.GoodsTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeServices {

    @Autowired
    private GoodsTypeDao goodsTypeDao;

    @Override
    public int addGoodsType(GoodsType goodsType) {
        int ans = 0;
        try{
            ans=goodsTypeDao.insertGoodsType(goodsType);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ans;
    }

    @Override
    public List<GoodsType> queryType() {
        List<GoodsType> goodsTypesList = null;
        try{
            goodsTypesList = goodsTypeDao.queryGoodsType();
        }catch (Exception e){
            e.printStackTrace();
        }
        return goodsTypesList;
    }

    @Override
    public int deleteGoodsType(Integer id) {
        int ans = 0;
        try{
            ans = goodsTypeDao.deleteGoodsType(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ans;
    }

    @Override
    public int updateGoodsType(GoodsType goodsType) {
        int ans = 0;
        try{
            ans = goodsTypeDao.updateGoodsType(goodsType);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ans;
    }

    @Override
    public List<GoodsType> selectTypeAndGoods() {
        List<GoodsType> goodsTypeList = new ArrayList<>();
        goodsTypeList = goodsTypeDao.selectGoodsByType();
        return goodsTypeList;
    }
}
