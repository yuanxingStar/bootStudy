package org.yuanxing.bootmvc.day1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2019-05-21 17:21
 * @see (1)@RequestHeader注解学习使用  获取请求头文件的信息
 *          value值 对应头文件中的键
 *          defaultValue 该参数的默认值 当键值没有传输时将使用这个参数进行赋值
 *          required 是否必须。默认为 true, 表示请求参数中必须包含对应的参数，若不存在，将抛出异常
 */

@Controller
@RequestMapping("/requestHeader")
public class RequestHeaderController {

    /**
     *
     * @param a1 Accept String
     * @param a2 Accept-Encoding String
     * @param a3 Accept-Language String
     * @param a4 Cache-Control String
     * @param a5 Connection String
     * @param a6 Cookie String
     * @param a7 Host String
     * @param a8 Pragma String
     * @param a9 Referer String
     * @param a10 Upgrade-Insecure-Requests String
     * @param a11 User-Agent String
     * @return
     */
    @ResponseBody
    @RequestMapping("/header")
    public Map<String,Object> header(
            @RequestHeader(value = "Accept") String a1,
            @RequestHeader(value = "Accept-Encoding") String a2,
            @RequestHeader(value = "Accept-Language") String a3,
            @RequestHeader(value = "Cache-Control") String a4,
            @RequestHeader(value = "Connection") String a5,
            @RequestHeader(value = "Cookie") String a6,
            @RequestHeader(value = "Host") String a7,
            @RequestHeader(value = "Pragma") String a8,
            @RequestHeader(value = "Referer") String a9,
            @RequestHeader(value = "Upgrade-Insecure-Requests") String a10,
            @RequestHeader(value = "User-Agent") String a11
    ) {

        Map<String,Object> map = new HashMap<>();
        map.put("Accept", a1);
        map.put("Accept-Encoding", a2);
        map.put("Accept-Language", a3);
        map.put("Cache-Control", a4 );
        map.put("Connection", a5 );
        map.put("Cookie", a6 );
        map.put("Host", a7 );
        map.put("Pragma", a8 );
        map.put("Referer", a9 );
        map.put("Upgrade-Insecure-Requests", a10);
        map.put("User-Agent", a11);

        return map;
    }

}
