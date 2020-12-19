package com.mystudy;

import com.mystudy.controller.LoginController;
import com.mystudy.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        String config = "applicationContext.xml";
        //得到spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //通过名称获取LoginController对象
        LoginController controller = (LoginController) context.getBean("myController");
        //通过类型获取LoginController对象
        LoginController controller1 = context.getBean(LoginController.class);
        System.out.println(controller == controller1);
        System.out.println("===================================");
        User user1 = (User) context.getBean("user1");
        User user2 = (User) context.getBean("user2");
        System.out.println("user1=="+user1);
        System.out.println("user2=="+user2);
        System.out.println("===================================");
        User user3 = (User) context.getBean("userFactoryBean");
        System.out.println("user3=="+user3);

        //关闭容器
        ((ClassPathXmlApplicationContext) context).close();
    }
}
