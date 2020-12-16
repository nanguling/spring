package com.mystudy;

import com.mystudy.service.SomeService;
import com.mystudy.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {
    @Test
    public void test01(){
        SomeService someService = new SomeServiceImpl();
        someService.doSome();
    }

    /**
     * spring默认创建对象的时间：在创建spring的容器时，会创建配置文件中所有的对象
     * spring创建对象：默认调用的是无参构造方法
     */
    @Test
    public void test02() {
        //使用spring容器创建对象
        //1.指定spring配置文件的名称
        String config = "beans.xml";

        //2.创建表示spring容器的对象，ApplicationContext
        // ApplicationContext就是表示spring容器，通过这个容器对象就能获取对象
        // ClassPathXmlApplicationContext表示从类路径中加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        //3.从容器中获取对象
        //getBean("配置文件中的bean的id值")
        SomeService service = (SomeService) context.getBean("someService");

        //4.使用spring创建好的对象
        service.doSome();

    }

    /**
     * 获取spring容器中java对象得信息
     */
    @Test
    public void test03() {
        //1.指定spring配置文件的名称
        String config = "beans.xml";
        //2.创建表示spring容器的对象
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //使用spring提供的方法，获取容器中定义的对象的数量
        int nums = context.getBeanDefinitionCount();
        System.out.println("容器中对象的数量:"+nums);
        //容器中每个定义的对象的名称
        String[] names = context.getBeanDefinitionNames();
        for (String name:names) {
            System.out.println("容器中对象的名称:"+name);
        }
    }

    //获取一个非自定义类的对象
    @Test
    public void test04() {
        //1.指定spring配置文件的名称
        String config = "beans.xml";
        //2.创建表示spring容器的对象
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //3.获取容器中的对象
        Date date = (Date) context.getBean("myDate");
        System.out.println("Date:"+date);
    }
}
