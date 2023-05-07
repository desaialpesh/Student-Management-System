package com.alpesh.studentmanagementsystem.service;

import com.alpesh.studentmanagementsystem.model.Student;
import com.alpesh.studentmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {

        Student student1=studentRepository.getStudentsByRollNo(student.getRollNo());
        if (student1!=null ){
            //&& student1.getRollNo()!=student.getRollNo()
            throw new RuntimeException("“Student already exist");
        }else{
            student= studentRepository.save(student);
        }

        return student;
    }

    @Override
    public void editStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Page<Student> getAllStudent(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }
}
