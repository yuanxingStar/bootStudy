package org.yuanxing.bootmvc.day1.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shkstart
 * @create 2019-05-23 8:47
 * @see  (1) 主要用于bootmvc页面的跳转
 */

@Controller("mainController")
public class MainController {

    @RequestMapping("/mainPage")
    public String mainPage() {
        return "/mainPage";
    }

    @RequestMapping("/pathVariablePage")
    public String pathVariablePage() {
        return "/mvc1/pathVariablePage";
    }

    @RequestMapping("/requestHeaderPage")
    public String RequestHeaderPage() {
        return "/mvc1/requestHeaderPage";
    }

    @RequestMapping("/requestParamPage")
    public String RequestParamPage() {
        return "/mvc1/requestParamPage";
    }

    @RequestMapping("/requestBodyPage")
    public String RequestBodyPage() {
        return "mvc1/requestBodyPage";
    }

}
