package com.mystudy.handler;

import com.mystudy.uitl.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyIncationHandler implements InvocationHandler {
    //目标对象
    private Object target;//SomeServiceImpl类

    public MyIncationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("执行MyInvocationHandler中的invoke方法");
        System.out.println("method的方法名："+method.getName());

        //通过代理对象执行方法时，会调用之心那个这个invoke()
        Object res = null;
        if ("doSome".equals(method.getName())) {//JoinPoint
            ServiceTools.doLog();
            //执行目标类的方法，通过Method类实现
            res = method.invoke(target, args);//doOther（），doSome
            ServiceTools.doTrans();
        }else {
            res = method.invoke(target,args);
        }
        //返回目标方法的执行结果
        return null;
    }
}
