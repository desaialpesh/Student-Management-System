package com.alpesh.studentmanagementsystem.service;

import com.alpesh.studentmanagementsystem.model.Teacher;
import org.springframework.stereotype.Service;


public interface TeacherService {
/*
    Sign Up Teachar (Fields are Email, password, name, username, gender, and age).
    Password should be store as encrypted mode into DB.
2) Login Teacher
*/


    boolean signUp(Teacher teacher);
    boolean login(String userName,String password);
}
