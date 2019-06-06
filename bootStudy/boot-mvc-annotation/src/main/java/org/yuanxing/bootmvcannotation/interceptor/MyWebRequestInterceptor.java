package org.yuanxing.bootmvcannotation.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * @author shkstart
 * @create 2019-06-06 13:53
 * @see  (1) 测试  WebRequestInterceptor
 */

@Component("myWebRequestInterceptor")
public class MyWebRequestInterceptor implements WebRequestInterceptor {

    @Override
    public void preHandle(WebRequest request) throws Exception {
        System.out.println("request.getContextPath   ----" + request.getContextPath());
        //System.out.println("" + request.getDescription());
        //System.out.println("" + request.getHeader());
        //System.out.println("" + request.getParameter());
        System.out.println("request.getRemoteUser()  ----" + request.getRemoteUser());
        System.out.println("request.getHeaderNames()  ----" + request.getHeaderNames());
        //System.out.println("" + request.getHeaderValues().toString());
        System.out.println("request.getParameterMap()   ----" + request.getParameterMap());
        System.out.println("request.getParameterNames()    -----" + request.getParameterNames());
        System.out.println("request.getSessionMutex()    ----" + request.getSessionMutex().toString());

    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {

    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {

    }
}
