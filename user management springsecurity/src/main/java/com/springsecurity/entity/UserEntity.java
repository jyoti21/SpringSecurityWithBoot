package com.springsecurity.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_auth")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String email;

	private String mobile;

	private String password;

	private String role;

	private String userName;
	
	private String age;

	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;


	
}
