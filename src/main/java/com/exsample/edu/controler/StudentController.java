package com.exsample.edu.controler;

import com.exsample.edu.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> studentList = new ArrayList<>();
    private long countId = 0;

    @GetMapping("/student")
    public List<Student> getStudentList() {
        return studentList;
    }

    @PostMapping("/student")
    public long saveStudent(@RequestParam String name, @RequestParam String email, @RequestParam int age) {
        countId = countId + 1;
        Student savedStudent = new Student(countId, name, email, age);
        studentList.add(savedStudent);
        return savedStudent.getId();
    }

}
