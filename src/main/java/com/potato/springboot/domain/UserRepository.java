package com.potato.springboot.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	
	/**
	 * 方法名要以实体类中的属性名结尾
	 * @param name
	 * @return
	 */
	User findByName(String username);
}
