package com.springboot.mybatis.service;

import com.springboot.mybatis.dao.UserDao;
import com.springboot.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by WIN on 2017/9/30.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean  addUser(String username, String password) {
        return userDao.insertUser(username,password) == 1 ? true : false;
    }

    /**
     *  添加事务注解
     */
//    @Transactional
    public User addUserWithBackId(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userDao.insertUserWithBackId(user);
        int i = 1 / 0;
        return user;
    }
}
