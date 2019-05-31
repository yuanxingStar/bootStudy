package org.yuanxing.bootmvcannotation.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * @author shkstart
 * @create 2019-05-31 10:43
 * @see     (1) SpringMVC支持绑定枚举值参数。
 *              匹配规则 :
 *              字符串则尝试根据Enum#name()转换。
 *              如果找不到匹配的则返回null
 *
 */

public class EnumConverterFactory implements ConverterFactory<String, Enum> {

    @Override
    public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
        return new String2EnumConverter(targetType);
    }

    class String2EnumConverter<T extends Enum<T>> implements Converter<String, T> {

        private Class<T> enumType;

        private String2EnumConverter(Class<T> enumType) {
            this.enumType = enumType;
        }

        @Override
        public T convert(String source) {
            if (source != null && !source.isEmpty()) {
                try {
                    return Enum.valueOf(enumType, source);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
