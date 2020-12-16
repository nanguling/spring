package com.mystudy.ba03;

public class Student {
    private String name;
    private int age;

    //声明一个引用类型
    private School school;

    public Student() {
        System.out.println("Student类中无参构造方法被调用了");
    }

    //有参构造
    public Student(String name, int age, School school) {
        System.out.println("Student有参构造方法被调用了");
        this.name = name;
        this.age = age;
        this.school = school;
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
