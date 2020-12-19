package com.mystudy.service;

import com.mystudy.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> queryStudents();
    int addStudent(Student student);
}
