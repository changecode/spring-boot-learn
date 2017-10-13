package com.springboot.devtools;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by WIN on 2017/10/13.
 */
@Controller
@RequestMapping("/thymeleaf")
@Api("测试Thymeleaf和devtools")
public class ThymeleafController {

    @ApiOperation("第一个thymeleaf程序")
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "world") String name,Model model) {
        model.addAttribute("xname", name);
//        return "greet";
        return "index";
    }


    @ApiOperation("ajax operator thymeleaf")
    @ResponseBody
    @RequestMapping(value = "/ajax",method = RequestMethod.GET)
    public String ajax(@RequestParam("username") String username) {
        return username;
    }
}
