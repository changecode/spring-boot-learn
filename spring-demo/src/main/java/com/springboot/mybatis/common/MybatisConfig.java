package com.springboot.mybatis.common;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by WIN on 2017/9/30.
 * @MapperScan 扫描mapper接口所在包路径
 */
@Configuration
@MapperScan(basePackages = "com.springboot.mybatis.mapper")
public class MybatisConfig {

    @Autowired
    private Environment environment;

    /**
     * create datasource bean
     * @return
     */
    //@Primary 指定同一个接口有多个实现类可以注入时，默认选择哪一个。一般用于多数据源情况
    @Bean
    public DataSource getDataSource() throws Exception {
        Properties properties = new Properties();
        properties.put("driverClassName", environment.getProperty("jdbc.driverClassName"));
        properties.put("url", environment.getProperty("jdbc.url"));
        properties.put("username", environment.getProperty("jdbc.username"));
        properties.put("password", environment.getProperty("jdbc.password"));
        return DruidDataSourceFactory.createDataSource(properties);
    }

    /**
     * create SqlSessionFactory bean, import datasource bean
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(environment.getProperty("mybatis.typeAliasesPackage"));
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(
                environment.getProperty("mybatis.mapperLocations")));
        return sqlSessionFactoryBean.getObject();
    }

}
