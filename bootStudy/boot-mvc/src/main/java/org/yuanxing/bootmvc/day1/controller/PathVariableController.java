package org.yuanxing.bootmvc.day1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shkstart
 * @create 2019-05-21 14:36
 * @see (1)@PathVariable注解的学习使用
 *          带占位符的 URL 是 Spring3.0 新增的功能，该功能在SpringMVC 向 REST 目标挺进发展过程中具有里程碑的意义
 *          通过 @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中：URL 中的 {xxx} 占位符可以通过@PathVariable(“xxx“) 绑定到操作方法的入参中。
 *      (2) HiddenHttpMethodFilter 伪造DELETE和PUT请求
 */

@Controller
@RequestMapping("/pathVariableController")
public class PathVariableController {

    /**
     *
     * @param id Integer
     * @return String
     * @see (1)@PathVariable GET请求测试
     */
    @RequestMapping(value = "/get/{id}",
                    method = RequestMethod.GET)
    @ResponseBody
    public String getTest(@PathVariable("id") Integer id) {

        return "@PathVariable : GET   --" + id ;
    }


    /**
     *
     * @return String
     * @see (1)@PathVariable put请求测试
     */
    @RequestMapping(value = "/post/{id}",
                    method = RequestMethod.POST)
    @ResponseBody
    public String postTest(@PathVariable("id") Integer id) {

        return "@PathVariable : POST  --" + id;
    }


    /**
     *
     * @param id Integer
     * @return String
     * @see (1)@PathVariable delete请求测试
     *
     */
    @RequestMapping(value = "/delete/{id}",
                    method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteTest(@PathVariable("id") Integer id) {

        return "@PathVariable : DELETE   --" + id;
    }

    /**
     *
     * @param id Integer
     * @return String
     * @see (1)@PathVariable put请求测试
     */
    @RequestMapping(value = "/put/{id}",
                    method = RequestMethod.PUT)
    @ResponseBody
    public String putTest(@PathVariable("id") Integer id) {

        return "@PathVariable : PUT   --" + id;
    }


    /**
     *
     * @param id Integer
     * @param name String
     * @return String
     * @see (1)@PathVariable GET请求测试
     *      (2)测试多个参数
     */
    @RequestMapping(value = "/gets/{id}/{name}",
            method = RequestMethod.GET)
    @ResponseBody
    public String getsTest(@PathVariable("id") Integer id,
                          @PathVariable("name") String name) {

        return "@PathVariable : GETS   --" + id + "  " + name;
    }

}
