package com.mystudy;

import com.mystudy.ba01.Student;
import com.mystudy.ba02.School;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {

    @Test
    public void test01() {
        //1.指定spring配置文件的名称
        String config = "ba02/applicationContext.xml";
        //2.创建表示spring容器的对象
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //3.从容器中获得对象
        School school = (School) context.getBean("mySchool");
        Student student = (Student) context.getBean("mystudent");


        System.out.println("school=="+school);
        System.out.println("student=="+student);

    }

}
