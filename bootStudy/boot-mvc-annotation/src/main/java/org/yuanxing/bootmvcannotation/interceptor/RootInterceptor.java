package org.yuanxing.bootmvcannotation.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author shkstart
 * @create 2019-06-05 18:11
 * @see (1)  自定义拦截器 implements HandlerInterceptor
 *
 */

@Component("rootInterceptor")
public class RootInterceptor implements HandlerInterceptor {

    /**
     * @see 1.目标方法运行之前执行
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        System.out.println("preHandle..."+request.getRequestURI());

        return true;
    }

    /**
     * @see 2.目标方法执行正确以后执行
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    /**
     * @see 3.页面响应以后执行
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}
