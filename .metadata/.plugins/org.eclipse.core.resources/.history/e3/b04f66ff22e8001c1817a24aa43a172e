package com.nirsa.nw.web.app.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
public class ServicioAuthApplication {


	public static void main(String[] args) {
		SpringApplication.run(ServicioAuthApplication.class, args);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = "gilson55";
		String encodedPassword = passwordEncoder.encode(password);

		System.out.println();
		System.out.println("Password is         : " + password);
		System.out.println("Encoded Password is : " + encodedPassword);
		System.out.println();

		
		boolean isPasswordMatch = passwordEncoder.matches(password, "");
		System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);
	}

}
