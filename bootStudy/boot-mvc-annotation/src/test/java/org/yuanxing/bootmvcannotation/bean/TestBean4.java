package org.yuanxing.bootmvcannotation.bean;

import org.springframework.stereotype.Component;

/**
 * @author shkstart
 * @create 2019-05-30 15:07
 * @see
 */
@Component("testBean4")
public class TestBean4 {

    private String username;
    private String url;
    private String password;

    public void sayHello() {
        System.out.println("*******TestBean sayHello*******");
    }

    public String toString() {
        return "username:" + this.username + ",url:" + this.url + ",password:" + this.password;
    }

    public void start() {
        System.out.println("*******TestBean 初始化*******");
    }

    public void cleanUp() {
        System.out.println("*******TestBean 销毁*******");
    }
}
