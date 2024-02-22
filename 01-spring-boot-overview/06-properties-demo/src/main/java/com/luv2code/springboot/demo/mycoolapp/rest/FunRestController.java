package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo () {
        return "coach name: " + coachName + ", team name: " + teamName;
    }
    @GetMapping("/")
    public String sayHello() {
        return "Hello word!";
    }
    @GetMapping("/workout")
    public String getDailyWorkout () {
        return "Run a have 5k!";
    }
    @GetMapping("/fortune")
    public String getDailyFortune () {
        return "Today is your lucky day!";
    }
}
