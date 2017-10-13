package com.springboot.mutidatasource.mapper;

import com.springboot.mutidatasource.entity.UserMuti;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by WIN on 2017/9/30.
 */
public interface UserMutiMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results(value = { @Result(id = true, column = "id", property = "id"),
                        @Result(column = "name", property = "name") })
    public UserMuti getUser(@Param("id") int id);
}
