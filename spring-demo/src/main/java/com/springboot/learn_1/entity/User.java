package com.springboot.learn_1.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by WIN on 2017/9/29.
 *  @ConfigurationProperties(prefix = "user") 自动读取application.properties配置
 *  文件中user.*属性
 *  在没有使用@ConfigurationProperties的情况下,可使用@Value("${user.id}")
 *  注意： 如要使用ConfigurationProperties和@Value需将该bean添加@Component
 */
@Component
@ConfigurationProperties(prefix = "user")
public class User {

    //@Value("${user.id}")
    private int id;

    private String username;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
