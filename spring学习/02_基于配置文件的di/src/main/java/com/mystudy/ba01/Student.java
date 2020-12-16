package com.mystudy.ba01;

import com.mystudy.ba02.School;

public class Student {
    private String name;
    private int age;

    //声明一个引用类型
    private School school;

    public Student() {
        System.out.println("Student类中无参构造方法被调用了");
    }

    /**
     * 需要有set方法，没有就报错
     * Bean property 'name' is not writable or has an invalid setter method
     */
    public void setName(String name) {
        System.out.println("setName:"+name);
        this.name = name;
    }

    public void setAge(int age) {
        System.out.println("setAge:"+age);
        this.age = age;
    }

    public void setSchool(School school) {
        System.out.println("setSchool:"+school);
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
