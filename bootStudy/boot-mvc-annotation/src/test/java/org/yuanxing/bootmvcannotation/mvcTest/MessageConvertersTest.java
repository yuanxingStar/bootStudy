package org.yuanxing.bootmvcannotation.mvcTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.yuanxing.bootmvcannotation.config.MessageConvertersConfig;

/**
 * @author shkstart
 * @create 2019-05-30 17:28
 * @see (1) 测试消息转换器
 */
public class MessageConvertersTest {

    public static void main(String[] args) {
        // @Configuration注解的spring容器加载方式，用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(MessageConvertersConfig.class);

    }
}
