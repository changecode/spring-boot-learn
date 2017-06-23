package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/springboot")
@Controller
@EnableAutoConfiguration
public class SampleSpringBootController {

	@RequestMapping("/hello")
	@ResponseBody
	String startSpringboot() {
		return "spring boot";
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(SampleSpringBootController.class, args);
	}
}
