package com.mystudy.uitl;

import java.util.Date;

public class ServiceTools {
    public static void doLog() {
        System.out.println("执行方法的时间:"+new Date());
    }

    public static void doTrans() {
        System.out.println("提交事务");
    }
}
