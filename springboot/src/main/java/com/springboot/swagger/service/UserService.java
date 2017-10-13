package com.springboot.swagger.service;

import com.springboot.swagger.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by WIN on 2017/9/29.
 */
@Service
public class UserService {

    @Autowired
    private User user;

    public User getUser(){
        return user;
    }
}
