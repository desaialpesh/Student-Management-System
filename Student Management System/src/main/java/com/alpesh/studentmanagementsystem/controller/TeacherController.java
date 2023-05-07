package com.alpesh.studentmanagementsystem.controller;

import com.alpesh.studentmanagementsystem.model.Teacher;
import com.alpesh.studentmanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

 @Autowired
     TeacherService teacherService;

    @GetMapping("/dashboard")
    public String homePage() {
        return "teacher/home";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teacher/login";
    }

    @PostMapping("/login")
    public String performLogin(Model model, @RequestParam("username") String username, @RequestParam("password") String password) {
        boolean result = teacherService.login(username, password);
        System.out.println(result);
        if (result) {
            return "redirect:/student/view-student/0";
        }
        model.addAttribute("teacher", new Teacher());
        return "teacher/login";
    }

    @GetMapping("/signup")
    public String getSignUpPage(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teacher/signup";
    }

    @PostMapping("/signup")
    public String performSignUp(Model model, @ModelAttribute Teacher teacher) {
        boolean result = teacherService.signUp(teacher);
        if (result) {
            return "/teacher/home";
        }
        model.addAttribute("teacher", new Teacher());
        return "teacher/signup";
    }


}
