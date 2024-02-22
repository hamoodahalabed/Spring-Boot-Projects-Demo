package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component    // @ component marks class as a spring bean make it available for dependency injection
public class TennisCoach  implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley !";
    }
}
