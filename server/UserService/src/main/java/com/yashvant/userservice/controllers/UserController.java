package com.yashvant.userservice.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class UserController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from User Service";
    }

    @GetMapping("/user")
    public String user() {
        return "Hello User";
    }

}
