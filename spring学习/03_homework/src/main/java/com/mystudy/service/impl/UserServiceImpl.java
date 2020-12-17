package com.mystudy.service.impl;

import com.mystudy.dao.UserDao;
import com.mystudy.entity.User;
import com.mystudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务接口的实现类，负责实现里面的方法
 * 这是和用户打交道的类，用户可以过操作这个类来实现添加用户的功能(这里只做模拟)
 */

@Service("myService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;


    @Override
    public void addUser(User user) {
        //调用相应的dao中的方法完成添加用户的功能
        dao.insert(user);
    }
}
