package org.yuanxing.bootdatasource.aspect.impl;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.yuanxing.bootdatasource.annotation.DataSource;
import org.yuanxing.bootdatasource.config.MultipleDataSource;

import java.lang.reflect.Method;

/**
 * @author yuanxing
 * @version 0.0.1
 * @create 2019-06-24 15:09
 * @see (1)
 */
@Component
@Slf4j
public class UpdateDataSourceAspect {


    public void doBefore(JoinPoint joinPoint)
    {
        //获取方法上的注解
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        DataSource annotationClass = method.getAnnotation(DataSource.class);

        //获取类上面的注解
        if(annotationClass == null){
            annotationClass = joinPoint.getTarget().getClass().getAnnotation(DataSource.class);
        }

        if(annotationClass == null) {
            return ;
        }

        //获取注解上的数据源的值的信息
        String dataSourceKey  = annotationClass.name();
        //给当前的执行SQL的操作设置特殊的数据源的信息
        MultipleDataSource.setDataSourceKey(dataSourceKey);

        log.info("AOP动态切换数据源，className"+joinPoint.getTarget().getClass().getName()
                + "methodName"+method.getName()
                + ";dataSourceKey:"
                + dataSourceKey == "" ? "默认数据源":dataSourceKey);
    }

    public void doAfter(JoinPoint point) {
        //清理掉当前设置的数据源，让默认的数据源不受影响
        MultipleDataSource.removeDataSourceKey();
    }

    public static void main(String[] args) {
        String dataSourceKey = "";
        System.out.println(dataSourceKey == "" ? "默认数据源":dataSourceKey);
        dataSourceKey = "yuanxingDataSource";
        System.out.println(dataSourceKey == "" ? "默认数据源":dataSourceKey);
    }



}
