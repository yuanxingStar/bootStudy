package org.yuanxing.bootmvcannotation.bean;

/**
 * @author shkstart
 * @create 2019-05-30 14:33
 * @see (1) 测试的实体类bean
 */
public class TestBean2 {
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
