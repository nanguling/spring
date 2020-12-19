package com.mystudy.factory;

import com.mystudy.entity.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class UserFactoryBean implements FactoryBean<User> {
    public User getObject() throws Exception {
        User user = new User();
        user.setUsername("章鱼哥");
        user.setPassword("4657");
        return user;
    }

    public Class<?> getObjectType() {
        return User.class;
    }
}
