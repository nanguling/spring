package com.mystudy;

import com.mystudy.ba06.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest06 {

    @Test
    public void test01() {
        //1.指定spring配置文件的名称
        //加载的是主配置文件
        String config = "ba06/total.xml";
        //2.创建表示spring容器的对象
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //3.从容器中获得对象
        Student student = (Student) context.getBean("myStudent");

        System.out.println("student=="+student);
    }

}
