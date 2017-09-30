package com.springboot.mybatis.mapper;

import com.springboot.mybatis.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * Created by WIN on 2017/9/30.
 */
//@Mapper
public interface UserMapper {

    @Insert("insert into user(username,password) values(#{username}, #{password})")
    public int insertUser(@Param("username") String username, @Param("password") String password);

    public int insertUserWithBackId(User user);
}
