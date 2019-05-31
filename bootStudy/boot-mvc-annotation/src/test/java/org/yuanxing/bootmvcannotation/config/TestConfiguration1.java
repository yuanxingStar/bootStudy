package org.yuanxing.bootmvcannotation.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author yuanxing
 * @create 2019-05-30 14:29
 * @see (1) 测试@Configuration注解
 */

@Configuration
public class TestConfiguration1 {
    public TestConfiguration1() {
        System.out.println("************ TestConfiguration容器启动初始化  *************");
    }
}

