package com.mystudy;

import com.mystudy.entity.User;
import com.mystudy.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //测试数据
        //1.声明spring配置文件
        String config = "applicationContext.xml";
        //2.读取配置文件,获得spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //3.从容器中获取对象
        UserService service = (UserService) context.getBean("myService");
        User user = (User) context.getBean("myUser");
        service.addUser(user);
    }
}
