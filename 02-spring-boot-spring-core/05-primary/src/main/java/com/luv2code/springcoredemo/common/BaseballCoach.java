package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;
// @ component marks class as a spring bean make it available for dependency injection
@Component
public class BaseballCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice !";
    }
}
