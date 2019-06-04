package org.yuanxing.bootmvcannotation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yuanxing.bootmvcannotation.bean.Employee;

import java.util.Date;

/**
 * @author shkstart
 * @create 2019-06-04 16:35
 * @see
 */

@Controller("converterController")
@Slf4j
public class ConverterController {

    @RequestMapping("/converter1")
    @ResponseBody
    public Employee converter1(@RequestParam("employee") Employee employee) {
        return employee;
    }

    @RequestMapping("/converter2")
    @ResponseBody
    public Date converter2(@RequestParam("stringDate") Date date) {
        log.info("date ----" + date);
        return date;
    }

}
