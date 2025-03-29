package com.exsample.edu.controler;

import com.exsample.edu.model.Student;
import com.exsample.edu.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository repository;
    private long countId = 0;

    @GetMapping("/student")
    public List<Student> getStudentList() {
        return repository.getStudentList();
    }

    @PostMapping("/student")
    public long saveStudent(@RequestParam String name, @RequestParam String email, @RequestParam int age) {
        countId = countId + 1;
        Student savedStudent = new Student(countId, name, email, age);
        return  repository.save(savedStudent);
    }

    @GetMapping("/student/{id}")
    public Student getStudentByI(@PathVariable long id) {
        return repository.getById(id);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudentById(@PathVariable long id) {
        repository.deleteById(id);
    }
}
