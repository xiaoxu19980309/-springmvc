package com.example.springbootdemo.controller;

import com.example.springbootdemo.pojo.ShoppingCar;
import com.example.springbootdemo.service.ShoppingCarServices;
import com.example.springbootdemo.tools.ResponseCode;
import com.example.springbootdemo.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/shopping")
public class ShoppingCarController {
    @Autowired
    private ShoppingCarServices shoppingCarServices;

    @RequestMapping(value = "/addToCar",method = RequestMethod.POST)
    public Result addToCar(@RequestParam Integer user_id,@RequestParam Integer good_id,@RequestParam Integer count){
        int ans = 0;
        ShoppingCar shoppingCar = new ShoppingCar(user_id,good_id,count);
        try{
            ans = shoppingCarServices.addToCar(shoppingCar);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ans!=0){
            return Result.success(null,"加入购物车成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"加入购物车失败！");
        }
    }
}
