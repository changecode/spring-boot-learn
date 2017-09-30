package com.springboot.swagger.web;

import com.springboot.swagger.entity.User;
import com.springboot.swagger.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by WIN on 2017/9/29.
 */
@RestController
@RequestMapping("/user")
@Api("userController about api")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("获取用户信息")
    @ApiImplicitParams(
            {@ApiImplicitParam(paramType = "query", name="username",
                dataType = "String", required = true, value="username", defaultValue = "test")})
    @ApiResponses({
            @ApiResponse(code=400,message="username not null"),
            @ApiResponse(code=404,message = "page not found")
    })
    @RequestMapping(value="/getUser", method= RequestMethod.GET)
    public User getUser(@RequestParam("username") String username) {
        return userService.getUser();
    }
}
