package com.springboot.mutidatasource.web;

import com.springboot.mutidatasource.entity.UserMuti;
import com.springboot.mutidatasource.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WIN on 2017/9/30.
 */
@RestController
@RequestMapping("/muti")
@Api("mutidatasource test")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/test",method = RequestMethod.GET)
    public UserMuti getUser(@RequestParam("id") int id) {
        return userService.getUser(id);
    }
}
