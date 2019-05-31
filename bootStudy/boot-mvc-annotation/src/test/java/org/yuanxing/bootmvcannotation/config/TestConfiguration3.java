package org.yuanxing.bootmvcannotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.yuanxing.bootmvcannotation.bean.TestBean2;

/**
 * @author shkstart
 * @create 2019-05-30 14:41
 * @see
 */
public class TestConfiguration3 {

    public TestConfiguration3() {
        System.out.println("********TestConfiguration容器启动初始化********");
    }
    //@Bean注解注册bean,同时可以指定初始化和销毁方法
    @Bean(name="testBean",initMethod="start",destroyMethod="cleanUp")
    @Scope("prototype")
    public TestBean2 testBean() {
        return new TestBean2();
    }
}
