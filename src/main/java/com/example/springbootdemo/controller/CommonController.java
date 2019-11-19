package com.example.springbootdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.pojo.Goods;
import com.example.springbootdemo.pojo.GoodsType;
import com.example.springbootdemo.pojo.User;
import com.example.springbootdemo.service.GoodsServices;
import com.example.springbootdemo.service.GoodsTypeServices;
import com.example.springbootdemo.service.UserServices;
import com.example.springbootdemo.tools.JwtHelper;
import com.example.springbootdemo.tools.ResponseCode;
import com.example.springbootdemo.tools.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/common/")
public class CommonController {
    @Autowired
    private UserServices userServices;
    @Autowired
    private GoodsTypeServices goodsTypeServices;
    @Autowired
    private GoodsServices goodsServices;

    @Autowired
    private JwtHelper jwtHelper;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(HttpServletRequest request, HttpServletResponse response){
        User ans = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("loginName", username);
        try{
            ans = userServices.login(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ans!=null){
            JSONObject obj = jwtHelper.generateToken(claims);
            obj.put("userName",username);
            return Result.success(obj,"登录成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"用户登录失败！");
        }
    }

    @RequestMapping(value = "/adminLogin",method = RequestMethod.POST)
    public Result adminLogin(HttpServletRequest request, HttpServletResponse response){
        User ans = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("loginName", username);
        try{
            ans = userServices.adminLogin(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ans!=null){
            JSONObject obj = jwtHelper.generateToken(claims);
            return Result.success(obj,"登录成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"用户不存在！");
        }
    }

    @RequestMapping(value = "/getTypeList",method = RequestMethod.POST)
    public Result getTypeList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10")int pageSize){
        PageInfo<GoodsType> pageInfo=null;
        try{
            pageInfo = PageHelper.startPage(pageNum,pageSize).setOrderBy("id asc").doSelectPageInfo(()->this.goodsTypeServices.queryType());
        }catch(Exception e){
            e.printStackTrace();
        }
        if(pageInfo!=null){
            return Result.success(pageInfo,"获取商品类别列表成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"失败");
        }
    }

    @RequestMapping(value = "/getGoodsList",method = RequestMethod.POST)
    public Result getGoodsList(@RequestParam(required = false) Integer type_id,@RequestParam(required = false) String goods_name,
                               @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10")int pageSize,
                               @RequestParam(required = false) String status){
        PageInfo<Goods> goodsPageInfo = null;
        Goods goods = new Goods();
        goods.setType_id(type_id);
        goods.setGoods_name(goods_name);
        try{
            goodsPageInfo = PageHelper.startPage(pageNum,pageSize).setOrderBy("id asc").doSelectPageInfo(()->this.goodsServices.getGoodsList(goods,status));
        }catch (Exception e){
            e.printStackTrace();
        }
        if(goodsPageInfo!=null){
            return Result.success(goodsPageInfo,"获取商品列表成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"获取商品列表失败");
        }
    }
}
