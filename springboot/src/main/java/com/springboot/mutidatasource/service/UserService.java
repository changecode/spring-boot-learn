package com.springboot.mutidatasource.service;

import com.springboot.mutidatasource.dao.UserDao;
import com.springboot.mutidatasource.entity.UserMuti;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by WIN on 2017/9/30.
 */
@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    public UserMuti getUser(int id) {
        return  userDao.getUser(id);
    }
}
