package org.yuanxing.bootmvcannotation.mainTest;

import org.yuanxing.bootmvcannotation.bean.TestBean2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.yuanxing.bootmvcannotation.config.TestConfiguration2;

/**
 * @author shkstart
 * @create 2019-05-30 14:36
 * @see
 */
public class TestMain2 {
    public static void main(String[] args) {
        // @Configuration注解的spring容器加载方式，用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration2.class);
        // 如果加载spring-context.xml文件：
        // ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        //获取bean
        TestBean2 tb = (TestBean2) context.getBean("testBean");
        tb.sayHello();
    }
}
