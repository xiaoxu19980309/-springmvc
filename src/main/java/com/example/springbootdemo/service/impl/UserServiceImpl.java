package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.service.UserServices;
import com.example.springbootdemo.pojo.User;
import com.example.springbootdemo.mybatis.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserDao userDao;

    @Override
    public int register(User user) {
        int ans = 0;
        try{
            ans = userDao.insertUser(user.getUserName(),user.getPassword());
        }catch (Exception e){
            e.printStackTrace();
        }
        return ans;
    }

    @Override
    public User login(User user) {
        User ans = null;
        try{
            ans = userDao.queryUserByUserName(user.getUserName());
        }catch(Exception e){
            e.printStackTrace();
        }
        return ans;
    }
}
