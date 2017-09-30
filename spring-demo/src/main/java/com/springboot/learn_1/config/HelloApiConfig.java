package com.springboot.learn_1.config;

import com.springboot.learn_1.retrofit.api.HelloApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit.RestAdapter;

/**
 * Created by WIN on 2017/9/30.
 */
@Configuration
public class HelloApiConfig {

    @Autowired
    private RestAdapter restAdapter;

    @Bean
    public HelloApi getHelloAPI() {
        return restAdapter.create(HelloApi.class);
    }

}
