package com.alpesh.studentmanagementsystem.controller;

import com.alpesh.studentmanagementsystem.model.Student;
import com.alpesh.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String getAllStudent() {
        return "Dashboard";
    }

    //
    //      /*  String username = principal.getName();
    //        User user = this.userRepository.getUserByUserName(username);
    //
    //        // pagination
    //        Pageable pageRequest = PageRequest.of(page, 3);
    //        Page<Contact> contacts = this.contactRepository.findContactsByUser(user.getId(), pageRequest);*/

    @GetMapping("/add")
    public String loadAddStudent(Model model) {
        model.addAttribute("student", new Student());
        return "/student/addStudent";
    }

    @PostMapping("/add")
    public String actionAddStudent(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "/student/addStudent";
    }

    @GetMapping("view-student/{page}")
    public String showStudent(@PathVariable("page") Integer page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 3);
        Page<Student> studentPage = studentService.getAllStudent(pageRequest);
        model.addAttribute("currentpage", page);
        model.addAttribute("totalpages", studentPage.getTotalPages());
        model.addAttribute("students", studentPage);
        return "student/students";
    }

    // current page
    @GetMapping("/{id}")
    public String showSingleUser(@PathVariable("id") Integer id, Model model) {
        Student studentById = studentService.getStudentById(id);
        model.addAttribute("student", studentById);
        return "/student/singlestudent";
    }

}
