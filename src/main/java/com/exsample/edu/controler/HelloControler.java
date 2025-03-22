package com.exsample.edu.controler;

import com.exsample.edu.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {
    @GetMapping("/Hello")
    public String Hello(@RequestParam String Name) {
        return "Hello " + Name;
    }


    @GetMapping("/student")
    public Student getStudent() {
        Student st = new Student(1,
                "Valera",
                "valera@ya.ru",
                19);
    return st;
    }

}
