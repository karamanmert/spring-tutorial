package com.mertkaraman.springtutorial.student.service;

import com.mertkaraman.springtutorial.student.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    void addNewStudent(Student student);
    void deleteStudent(Long studentId);
    void updateStudent(Long studentId, String name, String email);
}
