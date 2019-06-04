package org.yuanxing.bootmvcannotation.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.yuanxing.bootmvcannotation.converter.EmployeeConverter;
import org.yuanxing.bootmvcannotation.converter.StringToDateConverter;
import org.yuanxing.bootmvcannotation.formatter.DatesFormatter;
import org.yuanxing.bootmvcannotation.util.ContextUtil;

/**
 * @author shkstart
 * @create 2019-05-31 10:33
 * @see (1) 配置类型转换器
 */

//@EnableWebMvc
@Configuration //测试时开启
@Slf4j
public class TypeConversionConfig implements WebMvcConfigurer {

    @Autowired
    private EmployeeConverter employeeConverter;


    /**
     * @see （1）此处采用@Bean的方式 在config类中注入bean
     *          也可以单独在外面采用@Component向容器中注入bean 在采用@Autowired获取容中存在的bean
     * @return
     */
    @Bean(name="stringToDataConverter")
    public StringToDateConverter converter() {
        return new StringToDateConverter("yyyy-MM-dd HH:mm:ss");
    }

    @Bean(name="dateFormatter")
    public DatesFormatter formatter() {
        return new DatesFormatter("yyyy-MM-dd HH:mm:ss");
    }



    @Override
    public void addFormatters(FormatterRegistry registry) {

        System.out.println("***注入转换器和格式化器");
        registry.addConverter(converter());
        registry.addFormatter(formatter());
        registry.addConverter(employeeConverter);



        ApplicationContext ac = ContextUtil.getApplicationContext();


        //获取容器中全部的Bean的名字
        String[] allBeanNames = ac.getBeanDefinitionNames();
        for(int i = 0 ; i < allBeanNames.length; i ++) {
            System.out.println(allBeanNames[i]);
        }


        /**
         * stringHttpMessageConverter
         * mappingJackson2HttpMessageConverter
         * messageConverters
         */
        try {
/*            System.out.println("**************  查看容器当前的converter");
            Map<String,Converter> converters = ac.getBeansOfType(Converter.class);
            System.out.println( "converters  --" + converters);
            System.out.println( "---------------------------------------------------" );
            System.out.println("**************  查看容器当前的formatter");
            Map<String,Formatter> formatters = ac.getBeansOfType(Formatter.class);
            System.out.println( "formatters  --" + formatters);*/

            StringToDateConverter stdc = ac.getBean(StringToDateConverter.class);
            DatesFormatter df = ac.getBean(DatesFormatter.class);
            System.out.println("**" + stdc);
            System.out.println("**" + df);

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
