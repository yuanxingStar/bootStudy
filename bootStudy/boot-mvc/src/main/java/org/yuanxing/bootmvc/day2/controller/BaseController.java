package org.yuanxing.bootmvc.day2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.yuanxing.bootmvc.day2.editor.BootDateEditor;
import org.yuanxing.bootmvc.day2.editor.BootDoubleEditor;
import org.yuanxing.bootmvc.day2.editor.BootIntegerEditor;

import java.util.Date;

/**
 * @author shkstart
 * @create 2019-06-04 19:07
 * @see  (1) @InitBinder来对页面数据进行解析绑定
 *           由 @InitBinder 标识的方法，可以对 WebDataBinder 对象进行初始化。WebDataBinder 是 DataBinder 的子类，用于完成由表单字段到 JavaBean 属性的绑定
 *           • @InitBinder方法不能有返回值，它必须声明为void。
 *           • @InitBinder方法的参数通常是是 WebDataBinder
 *
 *       (2) WebDataBinder是用来绑定请求参数到指定的属性编辑器.由于前台传到controller里的值是String类型的，
 *       当往Model里Set这个值的时候，如果set的这个属性是个对象，Spring就会去找到对应的editor进行转换，然后再set进去！
 *       Spring自己提供了大量的实现类（如下图所示的在org.springframwork.beans.propertyEditors下的所有editor），
 *       诸如CustomDateEditor ，CustomBooleanEditor，CustomNumberEditor等许多，基本上够用。  在平时使用SpringMVC时，会碰到javabean中有Date类型参数，
 *       表单中传来代表日期的字符串转化为日期类型，SpringMVC默认不支持这种类型的转换。我们就需要手动设置时间格式并在webDateBinder上注册这个编辑器
 *
 *       (3)@InitBinder() 中间的value值，用于指定表单属性或请求参数的名字，符合该名字的将使用此处的DataBinder。
 *       比如：student.id和student.note。student就得是中间的value值，这样才能接收得到。而且student会填充进WebDataBinder，这里binder对象就是student了。
 *       -@InitBinder("student")
 *       -public void initBinderStudent(WebDataBinder binder){
 *          binder.setFieldDefaultPrefix("student.");
 *          }
 *
 *        (4)
 *        WebDataBinder
 *        setFieldMarkerPrefix 字段前缀
 *        setFieldDefaultPrefix 设置字段默认值
 *        setBindEmptyMultipartFiles  设置是否绑定空的MultipartFile参数。默认为“true”
 *        DataBinder
 *        setDisallowedFields   注册不允许绑定的字段
 *        setAutoGrowNestedPaths
 *        setAutoGrowCollectionLimit 指定阵列和集合自动增长的限制。 默认值为256
 *        initBeanPropertyAccess 初始化此DataBinder的标准JavaBean属性访问权限
 *        initDirectFieldAccess 初始化此DataBinder的直接字段访问，作为默认bean属性访问的替代。
 *        setIgnoreUnknownFields 设置是否忽略未知字段，即是否忽略目标对象中没有相应字段的bind参数。默认为“true”
 *        setIgnoreInvalidFields 设置是否忽略无效字段，即是否忽略目标对象中具有*不可访问的相应字段的bind参数（例如，由于嵌套路径中的空值）。默认为false
 *        setAllowedFields 注册应该允许绑定的字段。默认为全部*字段
 *        setRequiredFields 注册每个绑定过程所需的字段。如果传入属性值列表中未包含其中一个指定字段，则将创建相应的“缺少字段”错误，错误代码为“required”（默认情况下为绑定错误处理器
 *        setMessageCodesResolver 设置用于将错误解析为消息代码的策略。将给定策略应用于基础错误持有者。 默认是DefaultMessageCodesResolver
 *        setBindingErrorProcessor 设置用于处理绑定错误的策略，即必填字段错误和{@code PropertyAccessException}。默认是DefaultBindingErrorProcessor
 *        setValidator 设置Validator以在每个绑定步骤后应用
 *        addValidators  添加验证器以在每个绑定步骤后应用
 *        replaceValidators 在每个绑定步骤后替换要应用的验证器
 *        addCustomFormatter

 */


@Controller("baseController")
public class BaseController {
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new BootDateEditor());
        binder.registerCustomEditor(Double.class, new BootDoubleEditor());
        binder.registerCustomEditor(Integer.class, new BootIntegerEditor());

        //binder.setDisallowedFields();
    }
}
