package com.springboot.lombok;

import lombok.Builder;
import lombok.Getter;

/**
 * Created by WIN on 2017/10/13.
 * 使用lombok插件，消除模板代码
 */
@Builder
@Getter
public class LombokTest {

    private Integer id;
    private String name;
}
