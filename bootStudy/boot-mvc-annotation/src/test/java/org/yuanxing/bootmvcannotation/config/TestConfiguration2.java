package org.yuanxing.bootmvcannotation.config;

import org.yuanxing.bootmvcannotation.bean.TestBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author shkstart
 * @create 2019-05-30 14:34
 * @see (1) 测试@Configuration注解
 */
@Configuration
public class TestConfiguration2 {
    public TestConfiguration2() {
        System.out.println("*************TestConfiguration容器启动初始化************");
    }
    // @Bean注解注册bean,同时可以指定初始化和销毁方法
    // @Bean(name="testBean",initMethod="start",destroyMethod="cleanUp")
    @Bean
    @Scope("prototype")
    public TestBean2 testBean() {
        return new TestBean2();
    }
}
