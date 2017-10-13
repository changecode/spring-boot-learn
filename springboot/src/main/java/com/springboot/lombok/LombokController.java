package com.springboot.lombok;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WIN on 2017/10/13.
 */
@RestController
@RequestMapping("/lombok")
public class LombokController {

    /*@RequestMapping("/testLombok")
    public LombokTest get() {
       return LombokTest.builder().name("123").build();
    }*/
}
