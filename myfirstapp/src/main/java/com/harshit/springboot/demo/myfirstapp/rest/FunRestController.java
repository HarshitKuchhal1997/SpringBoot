package com.harshit.springboot.demo.myfirstapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // inject properties for coach and team name

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose new endpoints for "team and coach info"

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: "+coachName+", Team name: "+teamName;
    }

    @GetMapping("/")
    public String sayHello(){
        return "Hello Spring World";
    }

    @GetMapping("/homepage")
    public String gethomepage(){
        return "Welcome to the Homepage";
    }

    @GetMapping("/about")
    public String about(){
        return "Do you want to know something about the project??";
    }

    @GetMapping("/workout")
    public String workout(){
        return "Run a hard 5K!!";
    }
}
