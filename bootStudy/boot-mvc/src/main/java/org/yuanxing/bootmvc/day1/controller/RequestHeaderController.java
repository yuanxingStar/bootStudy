package org.yuanxing.bootmvc.day1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shkstart
 * @create 2019-05-21 17:21
 * @see (1)@RequestHeader注解学习使用  获取请求头文件的信息
 *          value值 对应头文件中的键
 *          defaultValue 该参数的默认值 当键值没有传输时将使用这个参数进行赋值
 *          required 是否必须。默认为 true, 表示请求参数中必须包含对应的参数，若不存在，将抛出异常
 */

@Controller
@RequestMapping("/requestHeaderController")
public class RequestHeaderController {



}
