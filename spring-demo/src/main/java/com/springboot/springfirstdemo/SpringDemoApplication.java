package com.springboot.springfirstdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class SpringDemoApplication {

    @RequestMapping("/hello")
    public String testFirstWebSpringboot() {
        return "this is web page by springboot";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }



}
