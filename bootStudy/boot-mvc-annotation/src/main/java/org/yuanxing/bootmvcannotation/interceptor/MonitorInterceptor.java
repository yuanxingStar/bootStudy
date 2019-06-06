package org.yuanxing.bootmvcannotation.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author shkstart
 * @create 2019-06-06 15:36
 * @see  (1) 性能监控拦截器
 *
 */
@Component("monitorInterceptor")
public class MonitorInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(MonitorInterceptor.class);

    private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<>("Monitor-StartTime");

    private Long standard;

    public MonitorInterceptor() {
        // 响应标准时间，默认1秒。
        this.standard = 1000L;
    }

    public MonitorInterceptor(Long standard) {
        this.standard = standard;
    }

    public Long getStandard() {
        return standard;
    }

    public void setStandard(Long standard) {
        this.standard = standard;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            long beginTime = System.currentTimeMillis();
            startTimeThreadLocal.set(beginTime);
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            long beginTime = startTimeThreadLocal.get();
            long endTime = System.currentTimeMillis();
            long consume = endTime - beginTime;
            if	(consume > standard) {
                logger.warn("{} consume {}ms", request.getRequestURI(), consume);
            }
        }
    }
}
