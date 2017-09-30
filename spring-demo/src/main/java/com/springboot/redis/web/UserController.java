package com.springboot.redis.web;

import com.alibaba.fastjson.JSON;
import com.springboot.redis.common.Constant;
import com.springboot.redis.entity.User;
import com.springboot.redis.jedis.RedisTemplateOperator;
import com.springboot.redis.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WIN on 2017/9/29.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplateOperator redisTemplateOperator;

    @RequestMapping("/testJedisCluster")
    public User testJedisCluster(@RequestParam("username") String username) {
        String value = redisTemplateOperator.get(Constant.USER_FORWARD_CACHE_PREFIX,username);
        if(StringUtils.isBlank(value)) {
            redisTemplateOperator.set(Constant.USER_FORWARD_CACHE_PREFIX,
                    username, JSON.toJSONString(getUser()));
            return null;
        }
        return JSON.parseObject(value, User.class);
    }

    @RequestMapping("/getUser")
    public User getUser() {
        return userService.getUser();
    }
}
