package com.mystudy.ba07;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


//省略value
@Component("mystudent")
public class Student {

    @Value(value = "海绵宝宝")
    private String name;
    @Value(value = "25")
    private Integer age;

    /**
     * 引用类型赋值
     * @Resource：来自jdk中的注解，spring提供了对这个注解的功能支持，可以使用它给引用类型赋值，使用的也是自动注入的原理，默认byNmae
     * 位置：1.在属性定义的上面，无需set方法，推荐使用。
     *      2.在set方法的上面
     *
     * @Resource只是用byName方式，需要增加一个属性 name
     * name的值是bean的id(名称)
     */

    //只使用byName
    @Resource(name = "myschool")
    private School school;

    public Student() {
        System.out.println("student的无参构造方法被调用了");
    }

    public void setName(String name) {
        this.name = name;
    }

    //@Value(value = "29")
    public void setAge(Integer age) {
        System.out.println("set function is run..");
        this.age = age;
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
