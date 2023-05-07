package com.alpesh.studentmanagementsystem.repository;

import com.alpesh.studentmanagementsystem.model.Student;
import com.alpesh.studentmanagementsystem.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

/*
    Student getStudentsByRollNo(int rollNo);
*/

    Teacher getTeacherByEmail(String email);
    Teacher getTeacherByUsernameAndPassword(String username,String password);
}
