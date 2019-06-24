package org.yuanxing.bootdatasource.annotation;

import java.lang.annotation.*;

/**
 * @author yuanxing
 * @version 0.0.1
 * @create 2019-06-24 15:21
 * @see (1)
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default DataSource.main;

    public static String main = "mainDataSource";
}
