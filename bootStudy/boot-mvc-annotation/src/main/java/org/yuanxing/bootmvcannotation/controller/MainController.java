package org.yuanxing.bootmvcannotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shkstart
 * @create 2019-06-04 16:22
 * @see (1) 核心测试页面
 *
 *
 */

@Controller("mainController")
public class MainController {

    @RequestMapping("/mainPage")
    public String mainPage() {
        return "/mainPage";
    }


    @RequestMapping("/converterPage")
    public String converterPage() {
        return "/mvcannotation1/converterPage";
    }
}
