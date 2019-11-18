package com.example.springbootdemo.controller;

import com.example.springbootdemo.pojo.Goods;
import com.example.springbootdemo.pojo.OrderDetail;
import com.example.springbootdemo.pojo.User;
import com.example.springbootdemo.service.OrderServices;
import com.example.springbootdemo.service.UserServices;
import com.example.springbootdemo.tools.IdGenerator;
import com.example.springbootdemo.tools.JwtHelper;
import com.example.springbootdemo.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/order")
public class OrderController {
    @Autowired
    private OrderServices orderServices;
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private UserServices userServices;


    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public Result addOrder(@RequestParam String token, @RequestParam(required = false) List<Goods> list, @RequestParam(required = false) Integer is_pay){
        String userName = jwtHelper.getTokenUserName(token).toString();
        User user = new User();
        user=userServices.selectByUserName(userName);
//        Double total_price = list.stream().mapToDouble(goods -> goods.getGoods_price()*goods.getGoods_num()).sum();
//        Integer total_num = list.stream().mapToInt(goods -> goods.getGoods_num()).sum();
        String order_id = IdGenerator.get();
//        System.out.println(order_id);
        return null;
    }
}
