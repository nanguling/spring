package com.mystudy.ba05;

public class Student {
    private String name;
    private int age;

    //声明一个引用类型
    private School school;

    public Student() {

    }

    /**
     * 需要有set方法，没有就报错
     * Bean property 'name' is not writable or has an invalid setter method
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(School school) {
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
