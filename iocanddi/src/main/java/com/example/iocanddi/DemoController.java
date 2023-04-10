package com.example.iocanddi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach mychoch;

    // define a constructor for dependency injection
    @Autowired
    public DemoController(Coach theCoach){
        mychoch=theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return mychoch.getDailyWorkout();
    }









}
