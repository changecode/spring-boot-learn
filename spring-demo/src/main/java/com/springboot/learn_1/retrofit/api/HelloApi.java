package com.springboot.learn_1.retrofit.api;

import com.springboot.retrofit.entity.Hello;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

import java.util.List;

/**
 * 该接口指定了调用远程服务的方法的基本路径与参数以及返回值等
 * 路径都是相对路径，相对于setEndpoint("http://localhost:8081")指定的路径
 * 方式有@GET/@POST/@PUT/@DELETE等
 * 传递参数使用@Query（服务被调用方使用@RequestParam接收），路径中的传递参数使用@Path（Restful风格），还可以直接传递一个对象@Body（服务被调用方使用@RequestBody接收），参数在请求头中@Header（服务被调用方使用@RequestHeader接收）
 * Created by WIN on 2017/9/30.
 */
public interface HelloApi {

    @GET("/hello/getHelloWithQueryParameter")
    public Hello getHelloWithQueryParameter(@Query("name") String name);

    @POST("/hello/getHelloList")
    public List<Hello> getHelloList();

    @POST("/hello/getHelloListWithBody")
    public List<Hello> getHelloListWithBody(@Body Hello hello);
}
