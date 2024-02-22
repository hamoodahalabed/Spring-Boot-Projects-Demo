package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component    // @ component marks class as a spring bean make it available for dependency injection
/*@Primary      // when there is multiple make the track coach as primary coach*/
/*@Lazy // call me only if u need me*/
public class TrackCoach implements Coach{

    public TrackCoach () {
        System.out.println("In constructor:" + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k !";
    }
}
