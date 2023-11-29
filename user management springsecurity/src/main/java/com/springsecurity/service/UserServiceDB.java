package com.springsecurity.service;


import com.springsecurity.entity.UserEntity;
import com.springsecurity.exceptions.BadRequestException;
import com.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceDB {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public List<UserEntity> getAllUsers() {

        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities;
    }

    public UserEntity getUserByUserName(String userName) {
        UserEntity userEntity = userRepository.findByUserName(userName);
        if (Objects.isNull(userEntity))
            throw new BadRequestException("enter correct details of User");
        return userEntity;
    }

    public UserEntity addUser(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
        return userEntity;
    }
}
