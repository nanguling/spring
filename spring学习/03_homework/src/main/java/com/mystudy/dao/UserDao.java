package com.mystudy.dao;

import com.mystudy.entity.User;

/**
 * dao接口，所有功能实现有其实现类来完成，这样可以降低耦合，面向接口编程(这里只做模拟，并没有真实数据库的操作)
 */
public interface UserDao {
    //添加
    void insert(User user);
}
