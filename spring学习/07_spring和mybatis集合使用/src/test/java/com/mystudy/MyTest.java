package com.mystudy;

import com.mystudy.dao.StudentDao;
import com.mystudy.entity.Student;
import com.mystudy.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {

    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        String[] names = context.getBeanDefinitionNames();
        for (String name:names) {
            System.out.println("容器中对象的名字=="+name+"|"+"容器中对象的类型名称=="+context.getBean(name));
        }
    }

    @Test
    public void testDaoInsert() {
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //获取容器中dao对象
        StudentDao dao = (StudentDao) context.getBean("studentDao");
        //执行方法
        Student student = new Student();
        student.setId(6);
        student.setName("大聪明");
        student.setAge(25);
        //spring和mybatis整合在一起使用，事务是自动提交的。无需执行SqlSession.commit()
        int res = dao.insertStudet(student);
        System.out.println("添加 "+res+" 条数据");
    }

    @Test
    public void testService() {
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        /*StudentService service = (StudentService) context.getBean("myService");
        Student student = new Student(7,"大漂亮",23);
        int res = service.addStudent(student);
        System.out.println("添加 "+res+" 条数据");*/
        StudentService service = (StudentService) context.getBean("service");
        List<Student> list = service.queryStudents();
        list.forEach(student -> System.out.println(student));
    }
}
