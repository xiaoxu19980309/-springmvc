package com.example.springbootdemo.service;

import com.example.springbootdemo.pojo.User;

public interface UserServices {
    User register(User user);
    User login(User user);
}
