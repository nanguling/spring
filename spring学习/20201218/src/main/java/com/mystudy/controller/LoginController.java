package com.mystudy.controller;

import com.mystudy.entity.User;
import com.mystudy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller("myController")
public class LoginController {
    @Autowired
    private LoginService service;

    @Bean
    public User user1() {
        User user = new User();
        user.setUsername("海绵宝宝");
        user.setPassword("1234");
        return user;
    }

    @Bean
    public User user2() {
        User user = new User();
        user.setUsername("派大星");
        user.setPassword("5678");
        return user;
    }
}
