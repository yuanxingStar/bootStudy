package org.yuanxing.bootiocbean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.yuanxing.bootiocbean.bean.Black;
import org.yuanxing.bootiocbean.bean.Blue;
import org.yuanxing.bootiocbean.bean.Color;
import org.yuanxing.bootiocbean.bean.Red;

/**
 * @author shkstart
 * @create 2019-06-10 13:50
 * @see (1) 测试@Bean注解
 */

@Configuration
public class BeanConfig {

    @Bean
    public Color color(){
        return new Color("color","color");
    }

    @Bean
    public Red getRed() {
        return new Red("red","1");
    }

    @Bean(value="blue")
    public Blue getBlue() {
        return new Blue("blue" ,"2");
    }

    /**
     * @see (1) 测试多例Bean
     * @return
     */
    @Bean(value="black1")
    @Scope("prototype")
    public Black getBlack1() {
        System.out.println("多例black");
        return new Black("black","b1");
    }

    /**
     * @see (1) 测试单例bean
     * @return
     */
    @Bean(value="black2")
    @Scope("singleton")
    public Black getBlack2() {
        System.out.println("单例black");
        return new Black("black","b2");
    }

    /**
     * @see (1) 测试懒加载
     * @return
     */
    @Bean(value="black2")
    @Scope("singleton")
    @Lazy
    public Black getBlack3() {
        System.out.println("懒加载单例black");
        return new Black("black","b3");
    }



}
