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

    @GetMapping("/student")
    public List<Student> getStudentList() {
        return repository.findAll();
    }

    @PostMapping("/student")
    public long saveStudent(@RequestParam String name, @RequestParam String email, @RequestParam int age) {
        Student savedStudent = new Student(name, email, age);
        return  repository.save(savedStudent).getId();
    }

    @GetMapping("/student/{id}")
    public Student getStudentByI(@PathVariable long id) {
        return repository.getById(id);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudentById(@PathVariable long id) {
        repository.deleteById(id);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable long id, @RequestBody Student st) {
       Student student = repository.findById(id).get();

       student.setName(st.getName());
       student.setAge(st.getAge());
       student.setEmail(st.getEmail());

       return repository.save(student);
    }
}
