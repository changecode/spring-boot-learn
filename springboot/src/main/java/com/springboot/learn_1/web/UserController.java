package com.springboot.learn_1.web;

import com.springboot.learn_1.entity.User;
import com.springboot.learn_1.service.UserService;
import com.springboot.retrofit.entity.Hello;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by WIN on 2017/9/29.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public User getAndOutUserInfo() {
        return  userService.getUser();
    }

    /**
     * ========== test retrofit 
     */
    @ApiOperation("获取Hello信息,测试GETWithQueryParameter")
    @RequestMapping(value="/getHelloWithQueryParameter",method= RequestMethod.GET)
    public Hello getHello(@RequestParam("name") String name) {
        return userService.getHelloFromRetrofitWithQueryParameter(name);
    }

    @ApiOperation("获取获取Hello信息信息,测试POST")
    @RequestMapping(value="/getHelloList",method=RequestMethod.GET)
    public List<Hello> getHelloList() {
        return userService.getHelloFromRetrofitList();
    }

    @ApiOperation("获取Hello信息,测试POST")
    @RequestMapping(value="/getHelloListWithBody",method=RequestMethod.GET)
    public List<Hello> getHelloListWithBody() {
        return userService.getHelloFromRetrofitListWithBody(new Hello(888, "秋水"));
    }
}
