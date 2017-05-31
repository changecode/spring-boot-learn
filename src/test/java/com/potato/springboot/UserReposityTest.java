package com.potato.springboot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
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
}
