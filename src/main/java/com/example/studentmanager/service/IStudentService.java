package com.example.studentmanager.service;

import com.example.studentmanager.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void save(Student student);
}
