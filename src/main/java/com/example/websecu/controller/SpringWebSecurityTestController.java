package com.example.websecu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringWebSecurityTestController {

    @GetMapping("/welcome")
    public String getWelcomeSentence(){
        return "HELLO USER!";
    }

    @GetMapping("/elite-welcome")
    public String getEliteWelcome(){
        return "WELCOME, AUTHORIZED ELITE USER";
    }
}
