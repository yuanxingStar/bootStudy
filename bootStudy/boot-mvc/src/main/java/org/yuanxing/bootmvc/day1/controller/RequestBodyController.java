package org.yuanxing.bootmvc.day1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shkstart
 * @create 2019-05-24 13:53
 * @see (1) @RequestBody 注解学习
 *          -@requestBody注解常用来处理content-type不是默认的application/x-www-form-urlcoded编码的内容，比如说：application/json或者是application/xml等。
 *          一般情况下来说常用其来处理application/json类型。
 *      (2) @RequestBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)；GET方式无请求体，所以使用@RequestBody接收数据时，前端不能使用GET方式提交数据，而是用POST方式进行提交。在后端的同一个接收方法里，@RequestBody与@RequestParam()可以同时使用，@RequestBody最多只能有一个，而@RequestParam()可以有多个。
 *          注：一个请求，只有一个RequestBody；一个请求，可以有多个RequestParam。
 *
 *
 *      (3)结论
 *          结论①：@JsonAlias注解，实现:json转模型时，使json中的特定key能转化为特定的模型属性;但是模型转json时，
 *                对应的转换后的key仍然与属性名一致，见：上图示例中的name字段的请求与响应。
 *                -@JsonAlias(value={"Name","NAME"})
 *  *             -private String name;
 *                此时，json字符串转换为模型时，json中key为Name或为NAME或为name的都能识别。
 *
 *          结论②：@JsonProperty注解，实现：json转模型时，使json中的特定key能转化为指定的模型属性；同样的，模
 *                型转json时，对应的转换后的key为指定的key，见：示例中的motto字段的请求与响应。
 *                @JsonProperty("MOTTO")
 *                -private String motto;
 *                此时，json字符串转换为模型时，key为MOTTO的能识别，但key为motto的不能识别。
 *
 *          结论③：@JsonAlias注解需要依赖于setter、getter，而@JsonProperty注解不需要。
 *
 *          结论④：在不考虑上述两个注解的一般情况下，key与属性匹配时,默认大小写敏感。
 *
 *          结论⑤：有多个相同的key的json字符串中，转换为模型时，会以相同的几个key中，排在最后的那个key的值给模
 *                型属性复制，因为setter会覆盖原来的值。见示例中的gender属性。
 *
 *          结论⑥：后端@RequestBody注解对应的类在将HTTP的输入流(含请求体)装配到目标类(即:@RequestBody后面
 *                的类)时，会根据json字符串中的key来匹配对应实体类的属性，如果匹配一致且json中的该key对应的值
 *                符合(或可转换为)实体类的对应属性的类型要求时，会调用实体类的setter方法将值赋给该属性

 *

 */

@Controller
@RequestMapping("/requestBody")
public class RequestBodyController {


    @ResponseBody
    @RequestMapping("/post1")
    public String post1() {

        return "";
    }
}
