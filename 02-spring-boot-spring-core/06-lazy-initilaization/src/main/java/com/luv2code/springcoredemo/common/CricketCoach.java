package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

            // @ component marks class as a spring bean make it available for dependency injection
 @Component
 public class CricketCoach implements Coach{

     public CricketCoach () {
         System.out.println("In constructor:" + getClass().getSimpleName());
     }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes !";
    }
}
