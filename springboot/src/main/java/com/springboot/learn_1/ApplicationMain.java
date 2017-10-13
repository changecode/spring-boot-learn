package com.springboot.learn_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by WIN on 2017/9/29.
 */

/**
 * @SpringBootApplication = @Configuration+@EnableAutoConfiguration+@ComponentScan
 * 注意: 在无xml配置的情况下，主类要放在根包路径下，这样就明确指定了扫描包的路径为其
 * 修饰的主类的包路径 (这是一种推荐做法)
 * @ComponentScan 进行包的扫描，扫描路径由@EnableAutoConfiguration指定
 *
 * 每个jar都要有一个主方法，用于启动jar
 *  @SpringBootApplication = @Configuration  指明该类由spring容器管理
 *                  +  @EnableAutoConfiguration  无xml配置启动
 *                  + @ComponentScan 扫描包，如果主类不是位于根路径下，这里需要指定扫描路径
 * */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableSwagger2
public class ApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }
}
