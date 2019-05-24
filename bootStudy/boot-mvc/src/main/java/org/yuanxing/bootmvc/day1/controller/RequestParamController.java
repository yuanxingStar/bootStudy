package org.yuanxing.bootmvc.day1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author shkstart
 * @create 2019-05-21 17:16
 * @see (1) @RequestParam 注解学习使用
 *          将请求参数绑定至方法参数即你可以使用@RequestParam注解将请求参数绑定到你控制器的方法参数上
 *          （1.1）value：请求参数名（必须配置）
 *          （1.2）required：是否必需，默认为 true，即 请求中必须包含该参数，如果没有包含，将会抛出异常（可选配置）
 *          （1.3）defaultValue：默认值，如果设置了该值，required 将自动设为 false，无论你是否配置了required，配置了什么值，都是 false（可选配置）
 *      (2) 具体配置方法：
 *          （2.1）配置一个属性 @RequestParam("") 或 @RequestParam(value="")
 *          （2.2）配置多个属性 @RequestParam(value="", required=true, defaultValue="")
 *      (3) 值得注意的是：如果方法上的@RequestMapping 配置了 params 属性，则请求中也必须包含该参数
 *
 *      (4) @RequestParam用于GET请求获取参数值，不能用于POST请求，PUT和DELETE请求需要测试!!
 *
 */

@Controller
@RequestMapping("/requestParamController")
public class RequestParamController {

    /**
     *
     * @param id
     * @param age
     * @return
     * @see (1)@RequestParam GET请求测试
     */
    @RequestMapping(value = "/get",
                    method = RequestMethod.GET)
    @ResponseBody
    public String getTest(@RequestParam("id") Integer id,
                          @RequestParam(value = "age", required = false, defaultValue = "0") Integer age,
                          @RequestParam(value = "name") String name) {

        return "@RequestParam  GET   --id:" + id + " -- age:" + age + "  -- name:" + name ;
    }










}
