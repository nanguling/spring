package com.mystudy;

import com.mystudy.ba01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {

    @Test
    public void test01() {

        //1.指定spring配置文件的名称
        String config = "ba02/applicationContext.xml";

        //2.创建表示spring容器的对象，ApplicationContext

        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        //3.从容器中获取对象
        Student student = (Student) context.getBean("mystudent");

        //4.使用spring创建好的对象
        System.out.println("student=="+student);

        Date date = (Date) context.getBean("myDate");
        System.out.println("date:"+date);
    }

}
