package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.mybatis.ShoppingCarDao;
import com.example.springbootdemo.pojo.ShoppingCar;
import com.example.springbootdemo.service.ShoppingCarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCarServiceImpl implements ShoppingCarServices {
    @Autowired
    private ShoppingCarDao shoppingCarDao;

    @Override
    public int addToCar(ShoppingCar shoppingCar) {
        int ans = 0;
        try{
            ans = shoppingCarDao.insertGoodsToCar(shoppingCar);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ans;
    }

    @Override
    public int deleteShoppingCar(Integer id) {
        int ans = 0;
        ans = shoppingCarDao.deleteShoppingCar(id);
        return ans;
    }

    @Override
    public int deleteShoppingCarList(List<Integer> idList) {
        int ans = 0;
        ans = shoppingCarDao.deleteShoppingCarList(idList);
        return ans;
    }

    @Override
    public List<ShoppingCar> getShoppingCar(Integer UserId) {
        List<ShoppingCar> list = null;
        try{
            list=shoppingCarDao.selectShoppingCar(UserId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
