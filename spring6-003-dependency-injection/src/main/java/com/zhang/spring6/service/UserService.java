package com.zhang.spring6.service;

import com.zhang.spring6.dao.UserDao;

public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void insert(){
        userDao.save();
    }
}
