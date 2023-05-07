package com.alpesh.studentmanagementsystem.repository;

import com.alpesh.studentmanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student getStudentsByRollNo(int rollNo);
}
