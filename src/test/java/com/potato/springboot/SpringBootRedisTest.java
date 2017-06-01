package com.potato.springboot;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.potato.springboot.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringbootApplication.class)
public class SpringBootRedisTest {

	@Autowired
    private StringRedisTemplate stringRedisTemplate;
    
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Test
	public void test() throws Exception {
		stringRedisTemplate.opsForValue().set("123", "123");
		Assert.assertEquals("xxx", stringRedisTemplate.opsForValue().get("xxx"));
	}

	@Test
	public void testObj() throws Exception {
		User user = new User("123", 123);
		ValueOperations<String, User> operations = redisTemplate.opsForValue();
		operations.set("123", user);
		operations.set("123", user, 1, TimeUnit.SECONDS);
		Thread.sleep(1000);
		boolean exists = redisTemplate.hasKey("123");
		if (exists) {
			System.out.println("exists is true");
		} else {
			System.out.println("exists is false");
		}
	}
}
