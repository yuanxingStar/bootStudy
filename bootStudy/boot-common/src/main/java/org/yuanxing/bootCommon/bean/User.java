package org.yuanxing.bootCommon.bean;

import lombok.*;

import java.io.Serializable;

/**
 * @author shkstart
 * @create 2019-05-08 10:28
 * @see 1.用于测试的 实体类
 *      2.-@Data注解包含@Getter，@Setter，@ToString， @AllArgsConstructor, @NoArgsConstructor
 *      3. @NonNull 标注属性上 判断是否为null
 *      4. @EqualsAndHashCode 同时生成 equals和hashCode方法
 *          生成hashCode()和equals()方法，默认情况下，它将使用所有非静态，非transient字段。但可以通过在可选的exclude参数中来排除更多字段。
 *          或者，通过在parameter参数中命名它们来准确指定希望使用哪些字段。
 *      5. @toString()方法，默认情况下，它会按顺序（以逗号分隔）打印你的类名称以及每个字段。
 *         可以这样设置不包含哪些字段@ToString(exclude = "id") / @ToString(exclude = {"id","name"})
 *         如果继承的有父类的话，可以设置callSuper 让其调用父类的toString()方法，例如：@ToString(callSuper = true)
 *      6.@NoArgsConstructor生成一个无参构造方法。当类中有final字段没有被初始化时，编译器会报错，此时可用@NoArgsConstructor(force = true)，
 *         然后就会为没有初始化的final字段设置默认值 0 / false / null。
 *         对于具有约束的字段（例如@NonNull字段），不会生成检查或分配，因此请注意，正确初始化这些字段之前，这些约束无效
 *      7.@RequiredArgsConstructor会生成构造方法（可能带参数也可能不带参数），如果带参数，这参数只能是以final修饰的未经初始化的字段，
 *         或者是以@NonNull注解的未经初始化的字段@RequiredArgsConstructor(staticName = "of")会生成一个of()的静态方法，并把构造方法设置为私有的
 *      8.@Accessors 主要用于控制生成的getter和setter
 *         主要参数介绍
 *         fluent boolean值，默认为false。此字段主要为控制生成的getter和setter方法前面是否带get/set
 *         chain boolean值，默认false。如果设置为true，setter返回的是此对象，方便链式调用方法
 *         prefix 设置前缀 例如：@Accessors(prefix = "abc") private String abcAge  当生成get/set方法时，会把此前缀去掉
 *      9.@Wither 提供了给final字段赋值的一种方法
 *           -@Wither private final int age;
 *           -@Wither(AccessLevel.PROTECTED) @NonNull private final String name;
 *      10.@onX在注解里面添加注解的方式
 *          -@Getter(onMethod = @_(@Column(name="school_id")))
 *
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends Person implements Serializable {

    private static final long serialVersionUID;
    static {
        serialVersionUID = -5382048035630086079L;
    }

    public String userName;

    @NonNull
    public String passWord;
    public Integer age;
    public String address;
    public Integer sex;
    public String email;

}
