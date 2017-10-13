package com.springboot.mutidatasource.common.datasource;

import com.springboot.mutidatasource.dao.UserDao;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by WIN on 2017/9/30.
 */
@Aspect
@Component
public class DataSourceAspect {

    @Pointcut("execution(* com.springboot.mutidatasource.dao.*.*(..))")
    public void declareJointPointExpression() {}

    @Before("declareJointPointExpression()")
    public void setDataSourceKey(JoinPoint point) {
        if(point.getTarget() instanceof UserDao) {
            DatabaseContextHolder.setDatabaseType(DatabaseType.test1);
        } else{
//            DatabaseContextHolder.setDatabaseType(DatabaseType.test); 默认注册test数据源
        }
    }
}
