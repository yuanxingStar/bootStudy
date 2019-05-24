package org.yuanxing.bootmvc.day1.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author shkstart
 * @create 2019-05-24 10:15
 * @see   (1) filter类
 *        (2) 1、SpringBoot启动默认加载的Filter
 * 　　           characterEncodingFilter
                 hiddenHttpMethodFilter
                 httpPutFormContentFilter
                 requestContextFilter
                2019-05-24 11:06:00.669  INFO 1080 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
                2019-05-24 11:06:00.670  INFO 1080 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
                2019-05-24 11:06:00.670  INFO 1080 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
                2019-05-24 11:06:00.670  INFO 1080 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
 */

@Configuration
public class FilterConfig {


/*    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new HiddenHttpMethodFilter());
        bean.addUrlPatterns("/*");
        return bean;
    }*/
}
