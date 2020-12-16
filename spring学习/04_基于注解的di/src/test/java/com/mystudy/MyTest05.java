package com.mystudy;

import com.mystudy.ba05.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest05 {
    @Test
    public void test01() {
        //1.声明spring配置文件
        String config = "applicationContext.xml";
        //2.获得spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //3.从容器中获得对象
        Student student = (Student) context.getBean("mystudent");
        System.out.println("student=="+student);
    }
}
