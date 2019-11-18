package com.example.springbootdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.pojo.User;
import com.example.springbootdemo.service.UserServices;
import com.example.springbootdemo.tools.JwtHelper;
import com.example.springbootdemo.tools.ResponseCode;
import com.example.springbootdemo.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
