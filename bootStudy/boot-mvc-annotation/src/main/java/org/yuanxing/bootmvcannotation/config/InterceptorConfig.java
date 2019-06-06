package org.yuanxing.bootmvcannotation.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.yuanxing.bootmvcannotation.interceptor.MyWebRequestInterceptor;
import org.yuanxing.bootmvcannotation.interceptor.RootInterceptor;

/**
 * @author shkstart
 * @create 2019-06-05 16:50
 * @see (1) 自定义拦截器
 *      (2) InterceptorRegistry
 *              addInterceptor  添加一个拦截器 HandlerInterceptor
 *              addWebRequestInterceptor  添加一个拦截器  WebRequestInterceptor
 *          InterceptorRegistration
 *              addPathPatterns  为拦截器添加拦截路径
 *              excludePathPatterns   为拦截器添加不拦截的路径
 *              pathMatcher
 *              order
 *
 *       (3)HandlerInterceptor与WebRequestInterceptor的异同
 *          相同点: 两个接口都可用于Contrller层请求拦截，接口中定义的方法作用也是一样的。
 *          //HandlerInterceptor
 *              boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception;
 *              void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)throws Exception;
 *              void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception;
 *          //WebRequestInterceptor
 *              void preHandle(WebRequest request) throws Exception;
 *              void postHandle(WebRequest request, ModelMap model) throws Exception;
 *              void afterCompletion(WebRequest request, Exception ex) throws Exception;
 *          WebRequestInterceptor间接实现了HandlerInterceptor，只是他们之间使用WebRequestHandlerInterceptorAdapter适配器类联系。
 *          不同点:
 *          (a).WebRequestInterceptor的入参WebRequest是包装了HttpServletRequest 和HttpServletResponse的，通过WebRequest获取Request中的信息更简便。
 *          (b).WebRequestInterceptor的preHandle是没有返回值的，说明该方法中的逻辑并不影响后续的方法执行，所以这个接口实现就是为了获取Request中的信息，或者预设一些参数供后续流程使用。
 *          (c).HandlerInterceptor的功能更强大也更基础，可以在preHandle方法中就直接拒绝请求进入controller方法。
 *
 *       (4) 拦截器的优先级可使用里面的order属性进行配置 ，order值越小优先级越高
 *           如果order值相同那么优先级按照 配置的先后顺序
 *

 */

@EnableWebMvc //全面接管MVC配置
@Configuration //测试时开启
@Slf4j
@ServletComponentScan("org.yuanxing.bootmvcannotation.filter")
public class InterceptorConfig implements WebMvcConfigurer {

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
