package org.yuanxing.bootmvcannotation.interceptor;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.UUID;

/**
 * @author shkstart
 * @create 2019-06-06 14:54
 * @see  (1) 安全拦截器
 *       (2)
 */
@Component("securityInterceptor")
public class SecurityInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(getClass());

    private String securityInterceptor = "disable";

    /**
     * uri 是否以 ".xxx" 结尾。
     * @param uri
     * @return 是返回 "." 的索引，否返回 -1 。
     */
    private int uriEndWithDot(String uri) {
        if (StringUtils.isBlank(uri)) {
            return -1;
        }
        int dotIndex = uri.lastIndexOf(".");
        if (dotIndex > 0 && dotIndex < uri.length()) {
            return dotIndex;
        }
        return -1;
    }

    /**
     * 检查参数是否安全。
     * @param url 请求地址。
     * @param queryString 查询字符串。
     * @param key 参数键。
     * @param value 参数值。
     * @throws (1) HttpException 不安全时抛出异常。
     */
    private void checkSafe(String url, String queryString, String key, String value) {
        if (this.isSQLInject(value)) {
            String info = new StringBuffer()
                    .append("请求[").append(url).append(!StringUtils.isBlank(queryString) ? "?" + queryString : "").append("]被禁止：")
                    .append("参数 ").append(key).append(" 的值 ").append(value).append(" 存在 SQL 注入风险！")
                    .toString();
            logger.error(info);
            //throw new HttpException(info);
        }
        if (this.isXSS(value)) {
            String info = new StringBuffer()
                    .append("请求[").append(url).append(!StringUtils.isBlank(queryString) ? "?" + queryString : "").append("]被禁止：")
                    .append("参数 ").append(key).append(" 的值 ").append(value).append(" 存在 XSS 攻击风险！")
                    .toString();
            logger.error(info);
            //throw new HttpException(info);
        }
    }

    /**
     * 是否 XSS 攻击。
     * @param value 字符串型的参数值。
     * @return
     */
    private boolean isXSS(String value) {
        if (StringUtils.isBlank(value)) {
            return false;
        }

        value = value.toLowerCase();
        if ((value.contains("<") && value.contains(">"))
                || value.contains("alert")
                || value.contains("script")) {
            return true;
        }
        return false;
    }

    /**
     * 是否 SQL 注入。
     * @param value 字符串型的参数值。
     * @return
     * @throws UnsupportedEncodingException
     */
    private boolean isSQLInject(String value) {
        if (StringUtils.isBlank(value)) {
            return false;
        }
        value = value.toLowerCase();
        if (value.contains("%")) {
            try {
                value = URLDecoder.decode(value, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                logger.error("参数值转码失败：value={}", value, e);
                return true;
            }
        }
        // 处理其他字符：|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,
        String injectStr = "'|and |exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|or |+";
        String strArray[] = injectStr.split("\\|");
        for (String str : strArray) {
            if (value.contains(str)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            String url = request.getRequestURL().toString();
            String uri = request.getRequestURI();
            String queryString = request.getQueryString();
            HandlerMethod handlerMethod = (HandlerMethod) handler;

            // 1. 检查 uri 是否以 ".xxx" 结尾，是则抛出异常
            int dotIndex = this.uriEndWithDot(uri);
            if (dotIndex > -1) {
                throw new URISyntaxException(uri, "包含 \".xxx\" 后缀", dotIndex);
            }

            // 2. 不检查无参方法
            MethodParameter[] parameters = handlerMethod.getMethodParameters();
            if (ArrayUtils.isEmpty(parameters)) {
                return true;
            }

            // 3. 配置参数 security.interceptor (enable, disable) 控制是否安全检测
            if (!"enable".equalsIgnoreCase(securityInterceptor)) {
                return true;
            }

            // 4. 检查 @PathVariable 参数是否存在攻击风险
            RequestMapping requestMappingAnnotation = handlerMethod.getMethodAnnotation(RequestMapping.class);
            String[] mappings = requestMappingAnnotation.value();
            String[] uriItemArray = uri.split("/");
            String[] mappingItemArray;
            String mappingItem, key, value;
            for (String mapping : mappings) {
                if (mapping.contains("{") && mapping.contains("}")) {
                    mappingItemArray = mapping.split("/");
                    for (int i = 0; i < mappingItemArray.length; i++) {
                        mappingItem = mappingItemArray[i];
                        if (mappingItem.contains("{") && mappingItem.contains("}")) {
                            key = mappingItem.substring(mappingItem.indexOf("{") + 1, mappingItem.lastIndexOf("}"));
                            value = uriItemArray[i + 1];

                            //this.checkSafe(url, queryString, key, value);
                        }
                    }
                }
            }

            // 5. 检查 queryString 中的参数是否存在攻击风险
            Enumeration<String> names = request.getParameterNames();
            String uuid = UUID.randomUUID().toString();
            while (names.hasMoreElements()) {
                key = names.nextElement();
                value = uuid;
                try {
                    value = request.getParameter(key);
                } catch (Exception e) {	// 跳过无法转换成字符型的参数
                    continue;
                }

                //this.checkSafe(url, queryString, key, value);
            }
        }
        return true;
    }
}
