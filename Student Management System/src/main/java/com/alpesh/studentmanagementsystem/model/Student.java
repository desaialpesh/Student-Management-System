package com.alpesh.studentmanagementsystem.model;

import jakarta.persistence.*;

@Table(name = "STUDENT")
@Entity
public class Student {

    /* (Fileds of Student: - Name, rollNo, department, standard, gender, age)*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STUDENT_ID")
    private int id;
    @Column(name = "ROLL_NO")
    private int rollNo;
    @Column(name = "DEPARTMENT")
    private String department;
    @Column(name = "STANDARD")
    private int standard;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "AGE")
    private int age;

    public Student() {
    }

    public Student(int id, int rollNo, String department, int standard, String gender, int age) {
        this.id = id;
        this.rollNo = rollNo;
        this.department = department;
        this.standard = standard;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
