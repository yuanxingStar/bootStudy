package org.yuanxing.bootmvcannotation.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2019-06-06 10:02
 * @see  (1) 测试自定义 过滤器
 *       (2) @WebFilter 注解学习
 *
 */


@Component("testFilter1")
@WebFilter(filterName="testFilter1",urlPatterns = "/*")
public class TestFilter1 implements Filter {
    /**
     *  初始化执行
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //在DispatcherServlet之前执行
        System.out.println("############TestFilter1 doFilterInternal executed############");
        chain.doFilter(request, response);
        //在视图页面返回给客户端之前执行，但是执行顺序在Interceptor之后
        System.out.println("############TestFilter1 doFilter after############");
    }

    /**
     * 销毁执行
     */
    @Override
    public void destroy() {

    }
}
