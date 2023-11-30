package com.springsecurity.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class UserDto {

	private String email;

	private String mobile;

	private String password;


	private String firstName;


	private String lastName;


	private String middleName;

	private Date dateOfBirth;

	private UUID docId;

	private Short age;

	private String specialization;
}
