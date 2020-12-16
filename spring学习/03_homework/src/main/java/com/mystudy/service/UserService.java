package com.mystudy.service;

import com.mystudy.entity.User;

/**
 * 用户服务的接口，所有用户服务类都要实现该接口
 */
public interface UserService {
    //添加用户
    void addUser(User user);
}
