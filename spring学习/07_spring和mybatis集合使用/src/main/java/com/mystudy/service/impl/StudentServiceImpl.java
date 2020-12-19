package com.mystudy.service.impl;

import com.mystudy.dao.StudentDao;
import com.mystudy.entity.Student;
import com.mystudy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("service")
public class StudentServiceImpl implements StudentService {

    //调用dao完成数据库操作
    @Autowired
    private StudentDao dao;

    //通过set注入给dao赋值，因此需要dao的set方法
    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Student> queryStudents() {
        List<Student> list = dao.selectStudents();
        return list;
    }

    @Override
    public int addStudent(Student student) {
        int res = dao.insertStudet(student);
        return res;
    }
}
