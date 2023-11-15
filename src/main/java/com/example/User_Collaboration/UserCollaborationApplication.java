package com.example.User_Collaboration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserCollaborationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCollaborationApplication.class, args);
	}

}
