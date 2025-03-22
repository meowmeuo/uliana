package com.exsample.edu.controler;

import com.exsample.edu.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {
    @GetMapping("/hello")
    public String Hello(@RequestParam String name) {
        return "Hello " + name;
    }

}