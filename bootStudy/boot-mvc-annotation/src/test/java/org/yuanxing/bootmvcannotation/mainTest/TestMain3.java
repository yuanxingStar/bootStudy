package org.yuanxing.bootmvcannotation.mainTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.yuanxing.bootmvcannotation.bean.TestBean2;
import org.yuanxing.bootmvcannotation.config.TestConfiguration3;

/**
 * @author shkstart
 * @create 2019-05-30 14:41
 * @see
 */
public class TestMain3 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration3.class);
        TestBean2 tb = (TestBean2) context.getBean("testBean");
        tb.sayHello();
        System.out.println(tb);
        System.out.println("***************************");
        TestBean2 tb2 = (TestBean2) context.getBean("testBean");
        tb2.sayHello();
        System.out.println(tb2);
    }
}
