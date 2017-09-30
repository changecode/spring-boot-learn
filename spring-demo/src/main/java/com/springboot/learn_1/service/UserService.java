package com.springboot.learn_1.service;

import com.springboot.learn_1.entity.User;
import com.springboot.learn_1.retrofit.api.HelloApi;
import com.springboot.retrofit.entity.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private HelloApi helloApi;

    public Hello getHelloFromRetrofitWithQueryParameter(String name) {
        return helloApi.getHelloWithQueryParameter(name);
    }

    public List<Hello> getHelloFromRetrofitList() {
        return helloApi.getHelloList();
    }

    public List<Hello> getHelloFromRetrofitListWithBody(Hello hello) {
        return helloApi.getHelloListWithBody(hello);
    }
}
