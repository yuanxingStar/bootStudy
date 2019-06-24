package org.yuanxing.bootdatasource.util;

import lombok.extern.java.Log;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @author yuanxing
 * @version 0.0.1
 * @create 2019-06-24 14:34
 * @see (1)
 */
@Component
@Log
public class ContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(ContextUtil.applicationContext == null) {
            ContextUtil.applicationContext = applicationContext;
        }
        log.info("---------------------------------------------------------------------");

        log.info("========ApplicationContext配置成功,在普通类可以通过调用SpringUtils.getAppContext()获取applicationContext对象,applicationContext="+ContextUtil.applicationContext+"========");


        String[] allBeanNames = ContextUtil.applicationContext.getBeanDefinitionNames();

        for(int i = 0 ; i < allBeanNames.length; i ++) {
            log.info(allBeanNames[i]);
        }

        log.info("---------------------------------------------------------------------");
    }

    //获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //通过name获取 Bean.
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    //获取指定名字、类型的 Bean，指定的类型可以是其父类或所实现的接口
    public static <T> T getBean(String name,Class<T> type){
        return getApplicationContext().getBean(name, type);
    }


    //获取指定注解所有的 Bean
    public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType) {
        return getApplicationContext().getBeansWithAnnotation(annotationType);
    }

    //获取指定注解所有的 Bean 的名字
    public static String[] getBeanNamesForAnnotation(Class<? extends Annotation> annotationType) {
        return getApplicationContext().getBeanNamesForAnnotation(annotationType);
    }

    //获取容器中指定某类型、或实现某接口、或继承某父类所有的 Bean
    public static <T> Map<String, T> getBeansOfType(@Nullable Class<T> type) {
        return getApplicationContext().getBeansOfType(type);
    }

    //获取容器中指定某类型、或实现某接口、或继承某父类所有的 Bean 的名称
    public static String[] getBeanNamesOfType(@Nullable Class<?> type) {
        return getApplicationContext().getBeanNamesForType(type);
    }

    //获取容器中Bean的数量
    public static int getBeanDefinitionCount(){
        return getApplicationContext().getBeanDefinitionCount();
    }

    //获取容器中所有bean的名字
    public static String[] getBeanDefinitionNames() {
        return getApplicationContext().getBeanDefinitionNames();
    }
}
