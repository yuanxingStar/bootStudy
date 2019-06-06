package org.yuanxing.bootmvcannotation.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.yuanxing.bootmvcannotation.converter.EmployeeConverter;
import org.yuanxing.bootmvcannotation.converter.StringToDateConverter;
import org.yuanxing.bootmvcannotation.formatter.DatesFormatter;
import org.yuanxing.bootmvcannotation.interceptor.MyWebRequestInterceptor;
import org.yuanxing.bootmvcannotation.interceptor.RootInterceptor;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2019-05-30 9:28
 * @see (1) 基于java-annotaion的 mvc核心配置类
 *      (2) @Configuration 标注该类是一个配置类
 *
 * @version 0.0.2
 *
 */

//@Configuration
//@Slf4j
//@ServletComponentScan("org.yuanxing.bootmvcannotation.filter")
public class WebMvcConfig implements WebMvcConfigurer {


    @Autowired
    private EmployeeConverter employeeConverter;

    @Bean(name="stringToDataConverter")
    public StringToDateConverter converter() {
        return new StringToDateConverter("yyyy-MM-dd HH:mm:ss");
    }

    @Bean(name="dateFormatter")
    public DatesFormatter formatter() {
        return new DatesFormatter("yyyy-MM-dd HH:mm:ss");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("utf-8");
        registrationBean.setFilter(characterEncodingFilter);
        return registrationBean;
    }


    /**
     *
     * @param converters
     * @see (1) 配置fastjson消息转换器
     */
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        //1.需要定义一个convert转换消息的对象;
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //2.添加fastJson的配置信息，比如：是否要格式化返回的json数据;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //3处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<MediaType>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        //4.在convert中添加配置信息.
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);

        fastJsonConfig.setCharset(Charset.forName("UTF-8"));  //默认字符集
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteDateUseDateFormat);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        //5.将convert添加到converters当中.
        //将jackson 替换为  fastJson
        for (int i=0; i<converters.size(); i++) {
            if(converters.get(i) instanceof MappingJackson2HttpMessageConverter) {
                converters.set(i, fastJsonHttpMessageConverter);
            }
        }
    }

    /**
     *
     * @param registry
     * @see (1) 配置自定义的转换器和格式化器
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(converter());
        registry.addFormatter(formatter());
        registry.addConverter(employeeConverter);

    }

    /**
     *
     * @param registry
     * @see (1) 添加自定义拦截器
     */
    public void addInterceptors(InterceptorRegistry registry) {
        //添加一个 HandlerInterceptor
        registry.addInterceptor(new RootInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("")
                .order(5);

        //添加一个 WebRequestInterceptor
        registry.addWebRequestInterceptor(new MyWebRequestInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("")
                .order(0);
    }


}
