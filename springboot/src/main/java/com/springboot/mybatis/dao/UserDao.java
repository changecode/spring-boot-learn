package com.springboot.mybatis.dao;

import com.springboot.mybatis.entity.User;
import com.springboot.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by WIN on 2017/9/30.
 */
@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public int insertUser(String username, String password) {
        return userMapper.insertUser(username,password);
    }

    public int insertUserWithBackId(User user) {
        return userMapper.insertUserWithBackId(user);
    }
}
