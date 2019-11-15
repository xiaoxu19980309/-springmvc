package com.example.springbootdemo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.tools.ResponseCode;
import com.example.springbootdemo.tools.Result;
import com.example.springbootdemo.pojo.User;
import com.example.springbootdemo.service.UserServices;
import com.example.springbootdemo.tools.JwtHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/user")

public class UserController {
    @Autowired
    private UserServices userServices;

    @Autowired
    private JwtHelper jwtHelper;


    @RequestMapping(value = "/checkToken",method = RequestMethod.POST)
    public Result checkToken(HttpServletRequest request){
        return Result.success(jwtHelper.validateTokenAndGetClaims(request));
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Result register(HttpServletRequest request){
        User user = new User();
        int ans = 0;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String pswComfirm = request.getParameter("pswComfirm");
        if(!password.equals(pswComfirm)){
            return Result.fail(ResponseCode.ERROR.val(),"两次输入的密码不一致！");
        }
        user.setUsername(username);
        user.setPassword(password);
        try{
            if(userServices.login(user)!=null){
                return Result.fail(ResponseCode.ERROR.val(),"用户名已注册！");
            }else{
                ans = userServices.register(user);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        if(ans!=0){
            return Result.success(null,"注册成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"注册失败！");
        }
    }

    @RequestMapping(value = "/changePsw",method = RequestMethod.POST)
    public Result changePsw(HttpServletRequest request){
        User user = new User();
        int ans = 0;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String pswComfirm = request.getParameter("pswComfirm");
        if(!password.equals(pswComfirm)){
            return Result.fail(ResponseCode.ERROR.val(),"两次输入的密码不一致！");
        }
        user.setUsername(username);
        user.setPassword(password);
        try{
            ans=userServices.changePsw(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ans!=0){
            return Result.success(null,"修改密码成功!");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"修改密码失败！");
        }
    }

    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    public Result getUserList(@RequestParam(required = false) String username,@RequestParam(required = false) String phone,@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10")int pageSize){
        PageInfo<User> pageInfo = null;
        try{
            pageInfo = PageHelper.startPage(pageNum,pageSize).setOrderBy("id asc").doSelectPageInfo(()->this.userServices.getUserList(username,phone));
        }catch (Exception e){
            e.printStackTrace();
        }
        if(pageInfo!=null){
            return Result.success(pageInfo);
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"获取用户列表失败！");
        }
    }

    @RequestMapping(value = "/changeAdminStatus",method = RequestMethod.POST)
    public Result changeAdminStatus(@RequestParam(required = false) int is_admin,@RequestParam String username){
        int ans = 0;
        User user = new User();
        user.setUsername(username);
        user.setIs_admin(is_admin);
        try{
            ans = userServices.changeAdminStatus(user);
        }catch(Exception e){
            e.printStackTrace();
        }
        if(ans!=0){
            return Result.success(null);
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"修改失败！");
        }
    }
}
