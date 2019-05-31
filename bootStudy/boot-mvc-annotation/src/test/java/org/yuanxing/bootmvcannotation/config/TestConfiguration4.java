package org.yuanxing.bootmvcannotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author shkstart
 * @create 2019-05-30 15:06
 * @see
 */

@Configuration
@ComponentScan(basePackages = "org.yuanxing.bootmvcannotation.bean")
public class TestConfiguration4 {

    public TestConfiguration4() {
        System.out.println("TestConfiguration容器启动初始化。。。");
    }

}
