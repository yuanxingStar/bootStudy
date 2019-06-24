package org.yuanxing.bootdatasource.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yuanxing.bootdatasource.aspect.impl.LogAspect;
import org.yuanxing.bootdatasource.aspect.impl.UpdateDataSourceAspect;

import java.sql.SQLException;

/**
 * @author yuanxing
 * @version 0.0.1
 * @create 2019-06-24 14:07
 * @see (1) 基础切面类
 */

@Component
@Aspect
@Slf4j
public class RootAspect {

    @Autowired
    private LogAspect logAspect;
    @Autowired
    private UpdateDataSourceAspect updateDataSourceAspect;

    //@Pointcut("bean(borrowService) ")
    @Pointcut("execution(public * org.yuanxing.bootdatasource.service.*.*(..))")
    public void pointCut(){

    }

    /**
     *
     * @param joinPoint
     * 1.获取进入方法名 方法参数
     */
    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){
        logAspect.doBefore(joinPoint);
        updateDataSourceAspect.doBefore(joinPoint);
    }

    /**
     * 2.获取返回结果
     */
    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        logAspect.doAfter(joinPoint);
        updateDataSourceAspect.doAfter(joinPoint);
    }

    /**
     * 3.异常捕捉
     */
    @AfterThrowing(value="pointCut()",throwing="error")
    public void afterThrowing(JoinPoint joinPoint, SQLException error){
        logAspect.afterThrowing(joinPoint, error);

    }

    /**
     *
     * 4.获取返回结果
     */
    @AfterReturning(pointcut="pointCut()",returning="returnVal")
    public Object afterReturn(JoinPoint joinPoint,Object returnVal){
       logAspect.afterReturn(joinPoint, returnVal);

        return returnVal;
    }
}
