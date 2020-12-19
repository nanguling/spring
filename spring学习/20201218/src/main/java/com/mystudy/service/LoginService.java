package com.mystudy.service;

import com.mystudy.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("myService")
public class LoginService {

    @Autowired
    private LoginDao dao;
}
