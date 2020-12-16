package com.mystudy.ba02;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//省略value
@Component("mystudent")
public class Student {


    /**
     * @Value：简单类型的赋值
     *  属性：value，String类型，表示简单类型的属性值
     *  位置：1.在属性定义的上面，无需set方法，推荐使用。
     *       2.在set方法的上面
     */
    @Value(value = "海绵宝宝")
    private String name;
//    @Value(value = "25")
    private Integer age;

    public Student() {
        System.out.println("student的无参构造方法被调用了");
    }

    public void setName(String name) {
        this.name = name;
    }

    @Value(value = "29")
    public void setAge(Integer age) {
        System.out.println("set function is run..");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
