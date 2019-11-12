package com.example.springbootdemo.service;

import com.example.springbootdemo.pojo.User;

public interface UserServices {
    int register(User user);
    User login(User user);
}
