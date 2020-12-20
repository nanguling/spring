package com.mystudy.dao;

import com.mystudy.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudents();

    int insertStudet(Student student);
}
