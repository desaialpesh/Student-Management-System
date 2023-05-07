package com.alpesh.studentmanagementsystem.service;

import com.alpesh.studentmanagementsystem.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface StudentService {
/*
    Add Student (Fileds of Student: - Name, rollNo, department, standard, gender, age)
4) Edit Student
5) Get student detail by id
6) Get all student list with pagination*/

    Student addStudent(Student student);
    void editStudent(Student student);
    Student getStudentById(int id);
    public Page<Student> getAllStudent(Pageable pageable);
}
