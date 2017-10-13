package com.springboot.mutidatasource.dao;

import com.springboot.mutidatasource.entity.UserMuti;
import com.springboot.mutidatasource.mapper.UserMutiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by WIN on 2017/9/30.
 */
@Repository
public class UserDao {

    @Autowired
    private UserMutiMapper userMutiMapper;

    public UserMuti getUser(int id) {
        /**也可使用aop方式*/
//        DatabaseContextHolder.setDatabaseType(DatabaseType.test);
        return userMutiMapper.getUser(id);
    }

}
