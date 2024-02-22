package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
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

    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("Inside doMyStartupStuff() method:" + getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanUpStuff() {
        System.out.println("Inside doMyCleanUpStuff() method:" + getClass().getSimpleName());
    }
}
