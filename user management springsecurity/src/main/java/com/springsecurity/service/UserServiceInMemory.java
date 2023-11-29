package com.springsecurity.service;


import com.springsecurity.entity.UserEntity;
import com.springsecurity.exceptions.BadRequestException;
import com.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceInMemory {

  List<UserEntity> usersList = new ArrayList<>();

  public UserServiceInMemory(){
      UserEntity user1 = UserEntity.builder().userName("jyoti").age("34").role("ADMIN").password("jyoti@123").build();
      UserEntity user2 = UserEntity.builder().userName("anurag").age("34").role("NORMAL").password("anurag@123").build();
      UserEntity user3 = UserEntity.builder().userName("veerawal").age("32").role("ADMIN").password("veerawal@123").build();
      usersList.add(user1);
      usersList.add(user2);
      usersList.add(user3);

  }

  public List<UserEntity> getAllUsers(){
      return this.usersList;
  }

  public UserEntity getUserByUserName(String userName){
      UserEntity userEntity = usersList.stream().filter(x->x.getUserName().equals(userName)).findAny().orElse(null);
      if (Objects.isNull(userEntity))
          throw new BadRequestException("User not found");
      return userEntity;
  }

  public UserEntity addUser(UserEntity userEntity){

      usersList.add(userEntity);
      return userEntity;

  }

    @Autowired
    UserRepository userRepository;


}
