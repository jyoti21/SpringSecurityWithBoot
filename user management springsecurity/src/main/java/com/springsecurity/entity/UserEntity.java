package com.springsecurity.entity;






import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;

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

	@Column(name = "crte_ts", updatable = false)
	private Timestamp crteTs;


	
}
