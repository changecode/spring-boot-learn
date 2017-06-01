package com.potato.springboot.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.potato.springboot.domain.User;
import com.potato.springboot.domain.UserRepository;

@RestController
public class HelloSpringBootController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/hello")
	public String index() {
		return "welcome to learn springboot";
	}
	
	/*@RequestMapping("/getUser") 
	public User getUser() {
		User user = new User("xxx",1);
		return user;
	}*/
	
	@RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
	
	@RequestMapping("/getUser")
    @Cacheable(value="user-key")
    public User getUser() {
    	User user = userRepository.findByName("aa");
    	System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");  
        return user;
    }
}
