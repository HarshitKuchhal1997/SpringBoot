package com.learningspring.demo.rest;

import com.learningspring.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudent;

    // define @PostConstructor to load the student data ... but it can be called only once

    @PostConstruct
    public void loadData(){

        theStudent=new ArrayList<>();

        theStudent.add(new Student("Harshit","Kuchhal"));
        theStudent.add(new Student("Reena","Yadav"));
        theStudent.add(new Student("Saksham","Gupta"));
        theStudent.add(new Student("Ravi","Prashant"));
    }

    // defining endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudent(){

        return theStudent;
    }

    // define endpoint or "/student/{studentID}" - returns student at a particular index

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // just index into the result ....

        // check the studentID again
        if ((studentId>=theStudent.size()) || (studentId<0)){
            throw new StudentNotFoundException("Student Not Found"+studentId);
        }

        return theStudent.get(studentId);
    }

    // Add an exception handler using @ExceptionHandler

    @ExceptionHandler
    public ResponseEntity<StudentErrorresponse> handleException(StudentErrorresponse exc){

        // create a StudentErrorresponse
        StudentErrorresponse error=new StudentErrorresponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

}
