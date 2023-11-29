package com.springsecurity.controller;


import com.springsecurity.entity.UserEntity;
import com.springsecurity.service.UserServiceDB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@Validated
@RestController
@RequestMapping("/user")
public class UserControllerDB {

        @Autowired
        UserServiceDB userServiceDB;

        @GetMapping("/all")
        public List<UserEntity> getAllUsers(){
            return userServiceDB.getAllUsers();
        }

        @GetMapping("/{userName}")
        public UserEntity getUserByUserName(@PathVariable("userName") String userName){
            return userServiceDB.getUserByUserName(userName);
        }
        @PostMapping("/add")
        public UserEntity addUser(@RequestBody UserEntity userEntity){

            return userServiceDB.addUser(userEntity);
        }

        @GetMapping("/get")
        public String getMessage(){

            return "this is an private api";


        }

    }


