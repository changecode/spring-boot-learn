package com.potato.springboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.potato.springboot.controller.HelloSpringBootController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringbootApplication.class)
public class SpringbootApplicationTests {

	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new HelloSpringBootController()).build();
	}
	
	/**
	 * 模拟spring MVC请求
	 * @throws Exception
	 */
	@Test
	public void getHello() throws Exception {
		printResultController("/hello");
	}
	
	@Test
	public void getUser() throws Exception {
		printResultController("/getUser");
	}
	
	/**
	 * 模拟请求获取json数据格式的结果
	 * @param methodName
	 * @throws Exception
	 */
	private void printResultController(String methodName) throws Exception {
		mvc.perform(MockMvcRequestBuilders.get(methodName).accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
	}
	
}
