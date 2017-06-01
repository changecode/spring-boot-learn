package com.potato.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.potato.springboot.domain.User;

public interface UserMapper {

	@Select("SELECT * FROM user")
	@Results({ @Result(property = "userSex", column = "user_sex"),
			@Result(property = "nickName", column = "nick_name") })
	List<User> getAll();

	@Select("SELECT * FROM user WHERE id = #{id}")
	@Results({ @Result(property = "userSex", column = "user_sex"),
			@Result(property = "nickName", column = "nick_name") })
	User getOne(Long id);

	@Insert("INSERT INTO user(userName) VALUES(#{userName})")
	void insert(User user);

	@Update("UPDATE user SET userName=#{userName} WHERE id =#{id}")
	void update(User user);

	@Delete("DELETE FROM user WHERE id =#{id}")
	void delete(Long id);
}
