package com.potato.springboot.domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long>{
	
	/**
	 * findXXBy,readAXXBy,queryXXBy,countXXBy, getXXBy后面跟属性名称
	 * 修改、删除、统计也是类似语法
	 * 基本上SQL体系中的关键词都可以使用，例如：LIKE、 IgnoreCase、 OrderBy
	 * 方法名要以实体类中的属性名结尾
	 * @param name
	 * @return
	 */
	User findByName(String username);
	
	/**
	 * spring data jpa已经帮我们实现了分页的功能，在查询的方法中，
	 * 需要传入参数Pageable ,当查询中有多个参数的时候Pageable建议做为最后一个参数传入
	 * @param pageable spring封装的分页实现类，使用的时候需要传入页数、每页条数和排序规则
	 * @return
	 */
	Page<User> findALL(Pageable pageable);
    
	Page<User> findByName(String userName,Pageable pageable);
	
	/**
	 * 查询前N个元素，或者支取前一个实体
	 */
	User findFirstByOrderByLastnameAsc();

	User findTopByOrderByAgeDesc();

	Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);

	List<User> findFirst10ByLastname(String lastname, Sort sort);

	List<User> findTop10ByLastname(String lastname, Pageable pageable);
	
	/**
	 * 自定义SQL查询
	 * Spring data 觉大部分的SQL都可以根据方法名定义的方式来实现，但是由于某些原因我们想使用自定义的SQL来查询，spring data也是完美支持的；
	 * 在SQL的查询方法上面使用@Query注解，
	 * 如涉及到删除和修改在需要加上@Modifying.也可以根据需要添加 @Transactional 对事物的支持，查询超时的设置等
	 */
	@Modifying
	@Query("update User u set u.userName = ?1 where c.id = ?2")
	int modifyByIdAndUserId(String  userName, Long id);
		
	@Transactional
	@Modifying
	@Query("delete from User where id = ?1")
	void deleteByUserId(Long id);
	  
	@Transactional(timeout = 10)
	@Query("select u from User u where u.emailAddress = ?1")
	    User findByEmailAddress(String emailAddress);
}
