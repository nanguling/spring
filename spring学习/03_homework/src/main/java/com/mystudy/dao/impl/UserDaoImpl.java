package com.mystudy.dao.impl;

import com.mystudy.dao.UserDao;
import com.mystudy.entity.User;

/**
 * dao的实现类
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void insert(User user) {
        System.out.println("完成用户添加功能");
    }
}
