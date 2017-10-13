package com.springboot.mutidatasource.common;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.springboot.mutidatasource.common.datasource.DatabaseType;
import com.springboot.mutidatasource.common.datasource.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by WIN on 2017/9/30.
 */
@Configuration
@MapperScan(basePackages = "com.springboot.mutidatasource.mapper")
public class MyBatisTwoConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource testDataSource() throws Exception {
        Properties properties = new Properties();
        properties.put("driverClassName", environment.getProperty("jdbc.driverClassName"));
        properties.put("url", environment.getProperty("jdbc.url"));
        properties.put("username", environment.getProperty("jdbc.username"));
        properties.put("password", environment.getProperty("jdbc.password"));
        return DruidDataSourceFactory.createDataSource(properties);
    }

    @Bean
    public DataSource test1DataSource() throws Exception {
        Properties properties = new Properties();
        properties.put("driverClassName", environment.getProperty("jdbc1.driverClassName"));
        properties.put("url", environment.getProperty("jdbc1.url"));
        properties.put("username", environment.getProperty("jdbc1.username"));
        properties.put("password", environment.getProperty("jdbc1.password"));
        return DruidDataSourceFactory.createDataSource(properties);
    }

    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier("testDataSource") DataSource testDataSource,
                                        @Qualifier("test1DataSource") DataSource test1DataSource ) {
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DatabaseType.test, testDataSource);
        targetDataSource.put(DatabaseType.test1, test1DataSource);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSource);
        dataSource.setDefaultTargetDataSource(testDataSource);

        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource ds) throws Exception {

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds);
        factoryBean.setTypeAliasesPackage(environment.getProperty("mybatis.typeAliasesPackage"));
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(environment.getProperty("mybatis.mapperLocations")));
        return  factoryBean.getObject();
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return  new DataSourceTransactionManager(dataSource);
    }
}
