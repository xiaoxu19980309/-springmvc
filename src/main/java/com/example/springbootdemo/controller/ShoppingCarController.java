package com.example.springbootdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.pojo.ShoppingCar;
import com.example.springbootdemo.pojo.User;
import com.example.springbootdemo.service.ShoppingCarServices;
import com.example.springbootdemo.service.UserServices;
import com.example.springbootdemo.tools.JwtHelper;
import com.example.springbootdemo.tools.ResponseCode;
import com.example.springbootdemo.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/shopping")
public class ShoppingCarController {
    @Autowired
    private ShoppingCarServices shoppingCarServices;
    @Autowired
    private UserServices userServices;
    @Autowired
    private JwtHelper jwtHelper;

    @RequestMapping(value = "/addToCar",method = RequestMethod.POST)
    public Result addToCar(@RequestParam String userName,@RequestParam Integer good_id,@RequestParam Integer count){
        int ans = 0;
        User user = new User();
        try{
            user=userServices.selectByUserName(userName);
        }catch (Exception e){
            e.printStackTrace();
        }
        ShoppingCar shoppingCar = new ShoppingCar(user.getId(),good_id,count);
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

    @RequestMapping(value = "/getShoppingCar",method = RequestMethod.POST)
    public Result getShoppingCar(@RequestParam String token){
        Object obj = jwtHelper.getTokenUserName(token);
        String userName = obj.toString();
        User user = new User();
        List<ShoppingCar> list=null;
        try{
            user=userServices.selectByUserName(userName);
            list=shoppingCarServices.getShoppingCar(user.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
        if(list!=null){
            return Result.success(list,"获取购物车列表成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"获取购物车列表失败!");
        }
    }

    @RequestMapping(value = "/deleteShoppingCar",method = RequestMethod.POST)
    public Result deleteShoppingCar(@RequestParam Integer carId){
        int ans = 0;
        try{
            ans = shoppingCarServices.deleteShoppingCar(carId);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ans!=0){
            return Result.success(null,"删除成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"删除失败！");
        }
    }

    @RequestMapping(value = "/deleteShoppingCarList",method = RequestMethod.POST)
    @ResponseBody
    public Result deleteShoppingCarList(@RequestBody JSONObject data){
        JSONObject json = JSON.parseObject(data.toJSONString());
        String idList = json.getString("idList");
        List<Integer> list = null;
        if(!idList.isEmpty()){
            list = JSONObject.parseArray(idList,Integer.class);
        }
        int ans = 0;
        try{
            ans = shoppingCarServices.deleteShoppingCarList(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ans!=0){
            return Result.success(null,"删除成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"删除失败！");
        }
    }
}
