package com.mystudy.service.impl;

import com.mystudy.service.SomeService;

public class SomeServiceImpl implements SomeService {
    public SomeServiceImpl() {
        System.out.println("SomeServiceImpl的无参构造方法");
    }

    public void doSome() {
        System.out.println("执行了SomeServiceImpl的doSome()方法");
    }
}
