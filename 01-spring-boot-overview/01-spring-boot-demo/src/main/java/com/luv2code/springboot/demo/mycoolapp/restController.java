package com.luv2code.springboot.demo.mycoolapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {

    Coach myCoach;

    @Autowired
    restController (Coach myCoach) {
        this.myCoach = myCoach;
    }

    @GetMapping("/")
    public String getHome () {
        return "Home page";
    }

    @GetMapping("/workout")
        public String getWorkout () {
            return myCoach.getDaily();
        }

}
