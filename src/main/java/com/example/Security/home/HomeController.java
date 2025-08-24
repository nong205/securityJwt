package com.example.Security.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String home(){
        return "Welcome to Security Application";
    }

    @GetMapping("/api")
    public String secure(){
        return "Welcome to Security platform secure";
    }
}
