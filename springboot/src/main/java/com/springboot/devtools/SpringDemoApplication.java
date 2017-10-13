package com.springboot.devtools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SpringDemoApplication {

    public static void main(String[] args) {
//        System.setProperty("spring.devtools.restart.enabled", "true");
        SpringApplication.run(SpringDemoApplication.class, args);
    }



}
