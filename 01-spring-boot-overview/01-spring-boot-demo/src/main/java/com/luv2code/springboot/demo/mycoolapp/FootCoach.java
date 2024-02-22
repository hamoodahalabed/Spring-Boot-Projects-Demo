package com.luv2code.springboot.demo.mycoolapp;

import org.springframework.stereotype.Component;

@Component
public class FootCoach implements Coach{

    @Override
    public String getDaily() {
        return "kick the ball !!!";
    }
}
