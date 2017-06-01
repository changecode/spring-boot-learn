package com.potato.springboot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.potato.springboot.domain.User;
import com.potato.springboot.domain.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringbootApplication.class)
public class UserReposityTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
    public void test() throws Exception {
        userRepository.save(new User("aa1", 2));
        Assert.assertEquals(1, userRepository.findAll().size());
        userRepository.delete(userRepository.findByName("aa1"));
    }
	
	@Test
	public void basicJpaQuery() throws Exception {
		userRepository.findAll();
		userRepository.findOne(1l);
		userRepository.save(new User("1",1));
		userRepository.delete(new User("1",1));
		userRepository.count();
		userRepository.exists(1l);
	}
	
	@Test
	public void testJpaPageQuery() throws Exception {
		int page=1,size=10;
		Sort sort = new Sort(Direction.DESC, "id");
	    Pageable pageable = new PageRequest(page, size, sort);
	    userRepository.findALL(pageable);
	    userRepository.findByName("xxx", pageable);
	}
}
