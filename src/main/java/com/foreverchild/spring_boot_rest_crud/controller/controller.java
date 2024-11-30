package com.foreverchild.spring_boot_rest_crud.controller;

import com.foreverchild.spring_boot_rest_crud.dto.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class controller {

    List<Student> studentList;

    @PostConstruct
    public void loadData(){

        studentList = new ArrayList<>();

        studentList.add(new Student("james", "peters"));
        studentList.add(new Student("Mike", "cole"));
    }


    @GetMapping("/students")
    public List<Student> sayHello(){
        return studentList;
    }
}
