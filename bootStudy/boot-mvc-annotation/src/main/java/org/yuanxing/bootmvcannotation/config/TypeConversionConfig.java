package org.yuanxing.bootmvcannotation.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.yuanxing.bootmvcannotation.util.ContextUtil2;

import java.util.Map;

/**
 * @author shkstart
 * @create 2019-05-31 10:33
 * @see (1) 配置类型转换器
 */

@Configuration //测试时开启
@Slf4j
public class TypeConversionConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        ApplicationContext ac = ContextUtil2.getApplicationContext();

        String[] allBeanNames = ac.getBeanDefinitionNames();
        System.out.println(allBeanNames);

        try {
            System.out.println("**************  查看容器当前的converter");
            Map<String,Converter> converters = ac.getBeansOfType(Converter.class);
            System.out.println( "converters  --" + converters);
            System.out.println( "---------------------------------------------------" );
            System.out.println("**************  查看容器当前的formatter");
            Map<String,Formatter> formatters = ac.getBeansOfType(Formatter.class);
            System.out.println( "formatters  --" + formatters);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
