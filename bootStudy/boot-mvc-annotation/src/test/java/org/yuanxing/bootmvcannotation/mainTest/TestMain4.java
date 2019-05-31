package org.yuanxing.bootmvcannotation.mainTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.yuanxing.bootmvcannotation.bean.TestBean4;
import org.yuanxing.bootmvcannotation.config.TestConfiguration4;

/**
 * @author shkstart
 * @create 2019-05-30 15:08
 * @see
 */
public class TestMain4 {
    public static void main(String[] args) {
        // @Configuration注解的spring容器加载方式，用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration4.class);
        // 如果加载spring-context.xml文件：
        // ApplicationContext context = new
        // ClassPathXmlApplicationContext("spring-context.xml");
        //获取bean
        TestBean4 tb = (TestBean4) context.getBean("testBean4");
        tb.sayHello();
    }
}
