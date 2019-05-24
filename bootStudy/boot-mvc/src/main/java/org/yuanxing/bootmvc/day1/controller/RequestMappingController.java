package org.yuanxing.bootmvc.day1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shkstart
 * @create 2019-05-15 17:14
 * @see
 *      (1) @RequestMapping： 注解为控制器指定可以处理哪些URL 请求
 *          在控制器的类定义及方法定义处都可标注
 * –            类定义处：提供初步的请求映射信息。相对于 WEB 应用的根目录
 * –            方法处：提供进一步的细分映射信息。相对于类定义处的 URL。若
 *          类定义处未标注 @RequestMapping，则方法处标记的 URL 相对于 WEB 应用的根目录
 *         DispatcherServlet 截获请求后，就通过控制器上@RequestMapping 提供的映射信息确定请求所对应的处理方法。
 *
 *       (2) name String  为此映射指定名称。在类型级别和方法级别受支持！在两个级别上使用时，组合名称通过串联*和“＃”作为分隔符派生
 *           value String[] 此注释表示的主要映射。 这是{-@link #path}的别名。例如 {-@code @RequestMapping（“/ foo”）}等同于
 *                          {-@code @RequestMapping（path =“/ foo”）}。 在类型级别和方法级别受支持！
 *                          在类型级别使用时，所有方法级别映射都继承*此主映射，将其缩小为特定的处理程序方法。
 *           path String[] 路径映射URI（例如“/myPath.do”）。 还支持Ant风格的路径模式（例如“/myPath/*.do”）。
 *                          在方法级别，在类型级别表示的主映射内支持相对路径（例如“edit.do”）。 路径映射URI可能包含占位符（例如“/ $ {connect}”）。
 *                          在类型级别和方法级别受支持！在类型级别使用时，所有方法级别映射都继承*此主映射，将其缩小为特定的处理程序方法。
 *           method String[] 要映射的HTTP请求方法，缩小主映射： GET，POST，HEAD，OPTIONS，PUT，PATCH，DELETE，TRACE。
 *  *                        在类型级别和方法级别受支持！在类型级别使用时，所有方法级别映射都继承,此HTTP方法限制（即类型级别限制） 在解析处理程序方法之前检查）。
 *           params String[] 映射请求的参数，缩小主映射。任何环境的格式相同：一系列“myParam = myValue”样式*表达式，只有在找到每个这样的参数
 *                           时才会映射请求以具有给定值。使用“！=”运算符*可以取消表达式，如“myParam！= myValue”中所示。还支持“myParam”样式表达式，
 *                           这些参数必须存在于请求中（允许具有*任何值）。最后，“！myParam”样式表达式表明*指定的参数<i>不</ i>应该出现在请求中。在类型级别和方法级别受支持！
 *                           在类型级别使用时，所有方法级别映射都继承此参数限制（即类型级别限制在处理程序方法被解析之前得到检查）。参数映射被视为在类型级别强制执行的限制。
 *                           主路径映射（即指定的URI值）仍然必须唯一地标识目标处理程序，参数映射仅表示调用处理程序的前提条件。
 *           headers String[] 映射请求的标头，缩小主映射。 任何环境的格式相同：一系列“My-Header = myValue”样式表达式，只有在找到每个此类标题*时才会映射请求，
 *                           以获得给定值。使用“！=”运算符*可以取消表达式，如“My-Header！= myValue”中所示。还支持“My-Header”样式表达式，
 *                           必须在请求中存在此类标题（允许具有*任何值）。最后，“！My-Header”样式表达式表明*指定的标题<i>不</ i>应该出现在请求中。
 *                           还支持媒体类型通配符（*），用于Accept *和Content-Type等标题。例如，* <pre class =“code”>
 *                           *@RequestMapping（value =“/ something”，headers =“content-type = text / *”）
 *                           </ pre> *将匹配具有Content-Type的请求“text / html”，“text / plain”等 在类型级别和方法级别支持！
 *                           在类型级别使用时，所有方法级别映射继承此标头限制（即在解析处理程序方法之前检查类型级限制）。
 *           consumes String[] 映射请求的可消耗媒体类型，缩小主映射。 格式是单一媒体类型或媒体类型序列*，仅当{-@code Content-Type}与其中一种媒体类型匹配时才会映射请求。
 *                          示例：* <pre class =“code”> * consume =“text / plain”* consumes = {“text / plain”，“application / *”} * </ pre>
 *                          *表达式可以通过使用“ ！”运算符，如“！text / plain”，它匹配*除了“text / plain”之外的{-@code Content-Type}的所有请求。
 *                          * <p> <b>在类型级别和方法级别受支持！</ b> *在类型级别使用时，所有方法级别映射都会覆盖*此消耗限制。
 *           produces String[] 映射请求的可生成媒体类型，缩小主映射。 * <p>格式是单一媒体类型或媒体类型序列*，仅当{@code Accept}与其中一种媒体类型匹配时才会映射请求。
 *                          *示例：* <pre class =“code”> * produce =“text / plain”* produce = {“text / plain”，“application / *”} *
 *                          produce = MediaType.APPLICATION_JSON_UTF8_VALUE * </ pre> * <p >它会影响写入的实际内容类型，
 *                          例如，使用UTF-8编码生成JSON响应*，应使用{-@link org.springframework.http.MediaType＃APPLICATION_JSON_UTF8_VALUE}。
 *                          * <p>使用“！”可以取消表达式。运算符，如“！text / plain”，它匹配*除了“text / plain”之外的{@code Accept}的所有请求。
 *                          * <p> <b>在类型级别和方法级别支持！</ b> *在类型级别使用时，所有方法级别映射都会覆盖*，这会产生限制。
 *
 *      (3) path 和 value 上使用了 @AliasFor注解
 *          在同一个注解内，对两个不同的属性一起使用，互为别名，比如@RequestMapping中path和value成对使用，互为别名。 这两个属性的值必须相同
 */

@Controller
@RequestMapping("/requestMappingController")
public class RequestMappingController {

    private static String SUCCESS = "SUCCESS";

    @RequestMapping("/test1")
    @ResponseBody
    public String test1() {
        return SUCCESS;

    }

    @RequestMapping(value = "/test2",
                    path = "/test2" ,
                    method = {RequestMethod.GET,RequestMethod.POST},
                    name="test2",
                    params = {"username" , "age != 10"},
                    headers={"Accept-Language=en-US,zh;q=0.8"})
    @ResponseBody
    public String test2() {
        return SUCCESS;
    }
}
