package org.yuanxing.bootmvcannotation.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author shkstart
 * @create 2019-06-06 15:40
 * @see
 */
@Component("scopeInterceptor")
public class ScopeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            // 1. 把系统版本号的 MD5 摘要写到 session ，追加到静态资源尾部，实现浏览器自动重新加载
            HttpSession session = request.getSession();
            String systemVersion = (String) session.getAttribute("systemVersion");
            if (systemVersion == null) {
                //VersionServiceImpl versionService = ApplicationContextUtil.getBean("versionService", VersionServiceImpl.class);
                //systemVersion = versionService.getSystemVersion();
                //session.setAttribute("systemVersion", DigestUtils.md5Hex(systemVersion));
            }

            // 2、绑定到 LocalThread
            //ScopeUtil.setRequest(request);
            //ScopeUtil.setResponse(response);
        }

        return true;
    }
}
