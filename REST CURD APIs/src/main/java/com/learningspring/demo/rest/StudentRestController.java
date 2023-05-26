package com.learningspring.demo.rest;

import com.learningspring.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // defining endpoint for "/students" - return a list of studenrs

    @GetMapping("/students")
    public List<Student> getStudent(){

        List<Student> theStudent=new ArrayList<>();

        theStudent.add(new Student("Harshit","Kuchhal"));
        theStudent.add(new Student("Reena","Yadav"));
        theStudent.add(new Student("Saksham","Gupta"));
        theStudent.add(new Student("Ravi","Prashant"));

        return theStudent;
    }
}
