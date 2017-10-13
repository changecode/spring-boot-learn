package com.springboot.retrofit.web;

import com.springboot.retrofit.entity.Hello;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WIN on 2017/9/30.
 */
@RestController
@RequestMapping("/retrofit")
@Api("RetrofitController API")
public class RetrofitController {

    @ApiOperation("获取User信息：getUserWithQueryParameter")
    @RequestMapping(value="/getUserWithQueryParameter",method=RequestMethod.GET)
    public Hello getUserWithQueryParameter(@RequestParam("name") String Helloname) {
        if(Helloname.equals("nana")){
            return new Hello(777, "鬼泣");
        }
        return new Hello(1314, "秋水");
    }

    @ApiOperation("获取User信息：getUserList")
    @RequestMapping(value="/getUserList",method= RequestMethod.POST)
    public List<Hello> getUserList() {
        List<Hello> HelloList = new ArrayList<>();
        HelloList.add(new Hello(1314, "冬月"));
        HelloList.add(new Hello(2046, "夏雪"));
        return HelloList;
    }

    @ApiOperation("获取getUserList信息：getHelloListWithBody")
    @RequestMapping(value="/getHelloListWithBody",method=RequestMethod.POST)
    public List<Hello> getHelloListWithBody(@RequestBody Hello Hello) {
        List<Hello> HelloList = new ArrayList<>();
        if(Hello.getName().equals("索大")){
            HelloList.add(new Hello(13141, "雪走"));
            HelloList.add(new Hello(20461, "黑夜"));
            return HelloList;
        }
        HelloList.add(new Hello(1314, "时雨"));
        HelloList.add(new Hello(2046, "和道"));
        return HelloList;
    }
}
