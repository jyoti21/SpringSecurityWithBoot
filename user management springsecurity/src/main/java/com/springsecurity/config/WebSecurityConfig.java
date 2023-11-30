package com.springsecurity.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
// this annotation is used for method level authorizations
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}

// http basic authentication
@Override
protected void configure(HttpSecurity http) throws Exception {

        http
				.csrf().disable()
				.authorizeRequests()

				// api based authentication with full api url
				.antMatchers("/public/home/login").permitAll()

				// api based authentication using base controller url
				.antMatchers("/public/**").permitAll()

				// api and method based authentication
				.antMatchers(HttpMethod.POST,"/public/**").permitAll()

				// Role Based Authentication

				//.antMatchers("/users/all").hasRole("ADMIN")
				.antMatchers("/users/all").permitAll()

				.antMatchers("/user/**").permitAll()

                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

}


// in memory basic auth using user detail service
@Bean
public UserDetailsService userDetailsService(){

	UserDetails ramesh = User.builder()
			.username("anurag")
			.password(passwordEncoder().encode("password"))
			.roles("NORMAL")
			.build();

	UserDetails admin = User.builder()
			.username("lokesh")
			.password(passwordEncoder().encode("admin"))
			.roles("ADMIN")
			.build();

	return new InMemoryUserDetailsManager(ramesh, admin);
}

}