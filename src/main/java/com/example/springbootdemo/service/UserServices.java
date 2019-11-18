package com.example.springbootdemo.service;

import com.example.springbootdemo.pojo.User;

import java.util.List;

public interface UserServices {
    int register(User user);
    User login(User user);
    User adminLogin(User user);
    int changePsw(User user);
    List<User> getUserList(String username,String phone);
    int changeAdminStatus(User user);
    User selectByUserName(String userName);
}
