package com.springsecurity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("/public/home")
public class HomeController {


    @GetMapping("/get")
    public String getMessage(){

        return "this is an public api";


    }

    @PostMapping("/login")
    public String getLoginPage(){

        return "this is login page";
    }

    @PostMapping("/register")
    public String getRegisterPage(){

        return "this is register page";


    }
}
