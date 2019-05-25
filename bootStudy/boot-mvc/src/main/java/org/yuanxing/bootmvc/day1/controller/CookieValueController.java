package org.yuanxing.bootmvc.day1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2019-05-24 16:18
 * @see (1)@CookieValue 注解的使用
 *          value：参数名称 JSESSIONID
 * 　　      required：是否必须
            defaultValue：默认值
 *
 */
@Controller
@RequestMapping("/cookieValueController")
public class CookieValueController {

    /**
     * @param sessionId String
     * @return String
     * @see @CookieValue的test
     */
    @RequestMapping("/cookie")
    @ResponseBody
    public String cookieValue(@CookieValue(value="JSESSIONID")String sessionId) {

        return "COOKIE JSESSIONID：" + sessionId;

    }

    @RequestMapping("/cookie2")
    @ResponseBody
    public Map<String,Object> cookieValue(@CookieValue(value="_ga")String ga,
                                          @CookieValue(value="_qddaz")String qddaz,
                                          @CookieValue(value="Hm_lvt_b6301567a88ada75709baab9b158318a")String hm,
                                           @CookieValue(value="tencentSig")String sig) {
        Map<String,Object> map = new HashMap<>();
        map.put("ga",ga);
        map.put("qddaz",qddaz);
        map.put("hm",hm);
        map.put("sig",sig);
        return map;
    }

}
