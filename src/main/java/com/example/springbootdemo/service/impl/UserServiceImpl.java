package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.service.UserServices;
import com.example.springbootdemo.pojo.User;
import com.example.springbootdemo.mybatis.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserDao userDao;

    @Override
    public int register(User user) {
        int ans = 0;
        try{
            ans = userDao.insertUser(user.getUsername(),user.getPassword());
        }catch (Exception e){
            e.printStackTrace();
        }
        return ans;
    }

    @Override
    public User login(User user) {
        User ans = null;
        try{
            ans = userDao.queryUserByUserName(user.getUsername());
        }catch(Exception e){
            e.printStackTrace();
        }
        return ans;
    }

    @Override
    public User adminLogin(User user) {
        User ans = null;
        try{
            ans = userDao.queryUserByUserNameAdmin(user.getUsername());
        }catch(Exception e){
            e.printStackTrace();
        }
        return ans;
    }

    @Override
    public int changePsw(User user){
        int ans = 0;
        try{
            ans = userDao.updateUser(user.getUsername(),user.getPassword(),user.getIs_admin(),user.getIs_delete());
        }catch(Exception e){
            e.printStackTrace();
        }
        return ans;
    }

    @Override
    public List<User> getUserList(String username,String phone) {
        List<User> list = null;
        try{
            list = userDao.queryUserAll(username,phone);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int changeAdminStatus(User user) {
        int ans = 0;
        try{
            ans = userDao.updateUser(user.getUsername(),user.getPassword(),user.getIs_admin(),user.getIs_delete());
        }catch(Exception e){
            e.printStackTrace();
        }
        return ans;
    }

    @Override
    public User selectByUserName(String userName) {
        User user=new User();
        try{
            user=userDao.queryUserByUserName(userName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
