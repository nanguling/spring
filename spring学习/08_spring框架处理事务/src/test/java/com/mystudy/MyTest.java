package com.mystudy;

import com.mystudy.service.MyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void testDao() {
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        MyService service = (MyService) context.getBean("service");
        //通过自定义异常，发现两张表的数据不一致！
        service.buy(1001,100);
    }
}
