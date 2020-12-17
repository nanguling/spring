package com.mystudy.ba02;

//目标类
public class SomeServiceImpl implements SomeService {
    public void doSome(String name,Integer age) {
        //给doSome方法增加一个功能，在doSome执行之前，输出方法的执行时间
        System.out.println("执行目标方法doSome");
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("执行目标方法doOther");
        return "ssss";
    }

    @Override
    public int[] doOther2(int[] arr) {
        arr[0] = 3;
        arr[1] = 4;
        return arr;
    }
}
