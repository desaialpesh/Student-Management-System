package com.alpesh.studentmanagementsystem.service;

import com.alpesh.studentmanagementsystem.model.Teacher;
import com.alpesh.studentmanagementsystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public boolean signUp(Teacher teacher) {
        Teacher teacher1=teacherRepository.getTeacherByEmail(teacher.getEmail());
        if (teacher1!=null){
            throw new RuntimeException("Teacher already exist");
        }else{
            teacherRepository.save(teacher);
            return true;
        }
    }

    @Override
    public boolean login(String userName, String password) {
        Teacher teacher = teacherRepository.getTeacherByUsernameAndPassword(userName, password);
        System.out.println(teacher);
        if (teacher!=null){
            return true;
        }
        return false;
    }
}
