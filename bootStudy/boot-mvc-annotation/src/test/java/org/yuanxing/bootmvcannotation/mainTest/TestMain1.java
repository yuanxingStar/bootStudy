package org.yuanxing.bootmvcannotation.mainTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.yuanxing.bootmvcannotation.config.TestConfiguration1;

/**
 * @author shkstart
 * @create 2019-05-30 14:31
 * @see
 */
public class TestMain1 {
    public static void main(String[] args) {
        // @Configuration注解的spring容器加载方式，用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration1.class);
        // 如果加载类路径下的spring-context.xml配置文件：
        // ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
    }
}
