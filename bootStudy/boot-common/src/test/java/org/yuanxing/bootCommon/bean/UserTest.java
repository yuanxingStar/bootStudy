package org.yuanxing.bootCommon.bean;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author shkstart
 * @create 2019-05-08 10:43
 * @see 1.类上使用@Slf4j，可以在类中直接使用log.info();
 *      2.@Log4j2 @Log4j @JBossLog 多种日志格式
 *      3.@Cleanup 资源释放
 *      4.@SneakyThrows 捕获异常 抛出异常
 *      5.@Synchronized 为方法加同步锁
 */
@Slf4j
public class UserTest {

    static User user;
    static {
        user = new User("yuan","yuan123",17,"qingdao",
                1,"18561703921@163.com");
    }



    public static void main(String[] args){
        //test1();
        //test2();
        test3();
    }

    /**
     * @see 1.测试lombok @Slf4j和@ToString使用
     */
    private static void test1() {
        log.info("info  --" + user.toString());
        log.debug("debug  --" + user.toString());
        log.error("error  --" + user.toString());
        log.warn("warn  --" + user.toString());
    }

    /**
     * @see 1.测试@NonNull使用 在注解属性赋值为null会抛出异常
     */
    private static void test2() {
        try{
            user.setPassWord("");
        }catch(Exception e){
            log.error("@NonNull 判断属性为空字符串抛出异常 ---" + e.getMessage());
        }
        try{
            user.setPassWord(null);
        }catch(Exception e){
            log.error("@NonNull 判断属性为null抛出异常 ---" + e.getMessage());
        }
    }


    /**
     * @see 1.测试@SneakyThrows 捕获异常 抛出异常
     */
    @SneakyThrows(NullPointerException.class)
    private static void test3() {
        throw new NullPointerException("手动抛出异常");
    }
}
