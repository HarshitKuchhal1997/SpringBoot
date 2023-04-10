package com.example.iocanddi.comman;

import org.springframework.stereotype.Component;

@Component
public class CricketCouch implements Coach{


    @Override
    public String getDailyWorkout() {
        return "Practice fast blowing for 15 minutes !!!";
    }
}
