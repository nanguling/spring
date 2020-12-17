package com.mystudy;

import com.mystudy.handler.MyIncationHandler;
import com.mystudy.service.SomeService;
import com.mystudy.service.impl.SomeServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyApp {
    public static void main(String[] args) {
        //使用jdk的Proxy创建代理对象
        //创建目标对象
        SomeService target = new SomeServiceImpl();
        //创建InvocationHandler对象
        InvocationHandler handler = new MyIncationHandler(target);
        //使用Proxy创建代理
        SomeService service = (SomeService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                                                    target.getClass().getInterfaces(),
                                                                    handler);
        //通过代理对象执行方法,会调用handler中的invoke方法
        service.doSome();
        System.out.println("=========================================");
        service.doOther();
    }
}
