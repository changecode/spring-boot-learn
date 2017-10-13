package com.springboot.learn_1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit.RestAdapter;

/**
 * Created by WIN on 2017/9/30.
 * @Configuration + @Bean = RestAdapter singleton
 */
@Configuration
public class RestAdapterConfig {

    /**
     *  appoint api url ex:http://localhost:8081
     * @return
     */
    @Bean
    public RestAdapter getRestAdapter() {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint("http://localhost:8081").build();
        return adapter;
    }

}
