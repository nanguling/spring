package com.mystudy;

import com.mystudy.ba01.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        SomeService proxy = (SomeService) context.getBean("service");
        System.out.println("proxy=="+proxy.getClass().getName());//com.sun.proxy.$Proxy7:jdk的动态代理
        //通过代理对象执行方法，实现目标方法执行时，增强了功能
        proxy.doSome("sss",52);
    }
}
