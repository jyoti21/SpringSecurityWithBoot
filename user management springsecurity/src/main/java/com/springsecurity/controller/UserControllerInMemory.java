package com.springsecurity.controller;


import com.springsecurity.entity.UserEntity;
import com.springsecurity.service.UserServiceInMemory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/users")
public class UserControllerInMemory {

    @Autowired
    UserServiceInMemory userServiceInMemory;

    @GetMapping("/all")
    public List<UserEntity> getAllUsers(){
        return userServiceInMemory.getAllUsers();
    }

//@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{userName}")
    public UserEntity getUserByUserName(@PathVariable("userName") String userName){
        return userServiceInMemory.getUserByUserName(userName);
    }
    @PostMapping("/add")
    public UserEntity addUser(@RequestBody UserEntity userEntity){

        return userServiceInMemory.addUser(userEntity);
    }

    @GetMapping("/get")
    public String getMessage(){

        return "this is an private api";


    }

}
