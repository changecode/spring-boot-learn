package com.potato.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.potato.springboot.domain.User;

@RestController
public class HelloSpringBootController {

	@RequestMapping("/hello")
	public String index() {
		return "welcome to learn springboot";
	}
	
	@RequestMapping("/getUser") 
	public User getUser() {
		User user = new User();
		user.setName("xxx");
		return user;
	}
}
