package com.example.iocanddi.rest;

import com.example.iocanddi.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    //public Coach myChoch;

    private Coach anotherCoach;

    // define a constructor for dependency injection

    @Autowired
    public DemoController(Coach theanotherCoach){
        System.out.println("In Constructor: "+getClass().getSimpleName());
        anotherCoach =theanotherCoach;
    }



/*

    // define a setter for dependency injection
    @Autowired
    public void setCoach(Coach theCoach){
        mychoch=theCoach;
    }

 */

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return anotherCoach.getDailyWorkout();
    }


}
