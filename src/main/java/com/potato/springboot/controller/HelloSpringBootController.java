package com.potato.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBootController {

	@RequestMapping("/hello")
	public String index() {
		return "welcome to learn springboot";
	}
}
