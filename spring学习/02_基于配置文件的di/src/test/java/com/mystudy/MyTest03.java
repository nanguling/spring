package com.mystudy;

import com.mystudy.ba03.School;
import com.mystudy.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest03 {

    @Test
    public void test01() {
        //1.指定spring配置文件的名称
        String config = "ba03/applicationContext.xml";
        //2.创建表示spring容器的对象
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //3.从容器中获得对象
        School school = (School) context.getBean("myschool");
        Student student = (Student) context.getBean("mystudent");
        Student student1 = (Student) context.getBean("mystudent2");


        System.out.println("school=="+school);
        System.out.println("student=="+student);
        System.out.println("student1=="+student1);
    }

}
