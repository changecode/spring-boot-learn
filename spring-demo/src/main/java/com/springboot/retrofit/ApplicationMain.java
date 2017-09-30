package com.springboot.retrofit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by WIN on 2017/9/30.
 * (exclude={DataSourceAutoConfiguration.class}) springboot默认会加载数据源
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableSwagger2
public class ApplicationMain implements EmbeddedServletContainerCustomizer{

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        configurableEmbeddedServletContainer.setPort(8081);
    }
}
