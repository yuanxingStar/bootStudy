package org.yuanxing.bootdatasource.aspect.impl;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author yuanxing
 * @version 0.0.1
 * @create 2019-06-24 14:46
 * @see (1) 对切面的日志记录
 */
@Component
@Slf4j
public class LogAspect {

    public void doBefore(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String arg = "";
        if(args != null && args.length>0) {
            for (int i = 0; i < args.length; i++) {
                arg = arg + args[i] + ",";
            }
            arg = arg.substring(0, arg.length() -1 );
            log.info("### 执行类名： < " + joinPoint.getSignature().getDeclaringType().getSimpleName()+" > ");
            log.info("### 执行方法名：< " + joinPoint.getSignature().getName()+" >");
            log.info("### 传入参数：< " + arg + ">");
        }

    }

    public void doAfter(JoinPoint joinPoint) {
        log.info("### after 类名： < " + joinPoint.getSignature().getDeclaringType().getSimpleName()+" >");
        log.info("### after 方法名： < " +joinPoint.getSignature().getName() + " >");
    }

    public void afterThrowing(JoinPoint joinPoint, SQLException error){
        //logger.info("### after 类名： < " + joinPoint.getSignature().getDeclaringType().getSimpleName() + " > ");
        log.info("### 异常方法名： < " +joinPoint.getSignature().getName() + " > ");
        log.info("### 捕获异常： < " +error.getMessage()+ " >");

    }

    public void afterReturn(JoinPoint joinPoint,Object returnVal){
        //logger.info("### afterReturning 类名： < " + joinPoint.getSignature().getDeclaringType().getSimpleName() + " >");
        //logger.info("### afterReturning 方法名： < " + joinPoint.getSignature().getName() + " >");
        log.info("### 执行返回结果： < " + returnVal + " >");

    }


}
