package com.mystudy.service.impl;

import com.mystudy.dao.UserDao;
import com.mystudy.entity.User;
import com.mystudy.service.UserService;

/**
 * 用户服务接口的实现类，负责实现里面的方法
 * 这是和用户打交道的类，用户可以过操作这个类来实现添加用户的功能(这里只做模拟)
 */
public class UserServiceImpl implements UserService {
    private UserDao dao;

    //在配置文件中使用set注入给dao赋值，因此需要set方法
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void addUser(User user) {
        //调用相应的dao中的方法完成添加用户的功能
        dao.insert(user);
    }
}
