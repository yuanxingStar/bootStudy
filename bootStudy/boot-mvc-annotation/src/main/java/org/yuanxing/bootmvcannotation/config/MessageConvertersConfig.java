package org.yuanxing.bootmvcannotation.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2019-05-30 17:18
 * @see (1) 全面接管MVC 配置消息转换器
 */

//@EnableWebMvc //全面接管MVC配置
//@Configuration //测试时开启
@Slf4j
public class MessageConvertersConfig implements WebMvcConfigurer {



    /**
     *
     * @param converters
     * @see (1) 读取默认的消息转换器
     *          ByteArrayHttpMessageConverter
     *          StringHttpMessageConverter
     *          StringHttpMessageConverter
     *          ResourceHttpMessageConverter
     *          ResourceRegionHttpMessageConverter
     *          xml.SourceHttpMessageConverter
     *          support.AllEncompassingFormHttpMessageConverter
     *          json.MappingJackson2HttpMessageConverter
     *          json.MappingJackson2HttpMessageConverter
     *          xml.Jaxb2RootElementHttpMessageConverter
     *      (2) MappingJackson2HttpMessageConverter  --> com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter
     *
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
        //SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.WriteMapNullValue
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteDateUseDateFormat);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        //fastJsonConfig.setSerializeConfig();  //序列化配置
        //fastJsonConfig.setParserConfig();     //解析器配置
        //fastJsonConfig.setSerializerFeatures();  //序列化器功能
        //fastJsonConfig.setSerializeFilter();   //序列化过滤器
        //fastJsonConfig.setFeature();          //特征


        //

        //5.将convert添加到converters当中.
        //将jackson 替换为  fastJson
        for (int i=0; i<converters.size(); i++) {
            if(converters.get(i) instanceof MappingJackson2HttpMessageConverter) {
                converters.set(i, fastJsonHttpMessageConverter);
            }
        }

        log.info("*******配置消息转换器***********");
        log.info("*******默认数量*******" + converters.size());
        for (int i=0; i<converters.size(); i++) {
            log.info("******i******" + converters.get(i).toString() + "  **   " + converters.get(i).getClass().getName());
        }
    }
}
