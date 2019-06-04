package org.yuanxing.bootmvcannotation.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shkstart
 * @create 2019-06-03 9:31
 * @see (1) String->Date 转换器
 */

public class StringToDateConverter implements Converter<String, Date> {

    private String datePattern;
    private Date targetFormateDate;

    public StringToDateConverter() {
        super();
    }

    public StringToDateConverter(String datePattern) {
        super();
        this.datePattern = datePattern;
        System.out.println("*********StringToDateConverter*********   创建完毕");
    }


    @Override
    public Date convert(String source) {
        System.out.println("***************  执行StringToDateConverter");
        try {

            SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
            // 是否严格解析日期,设置false禁止SimpleDateFormat的自动计算功能
            sdf.setLenient(false);
            targetFormateDate = sdf.parse(source);
        } catch (ParseException e) {
            // the error message will be displayed when using <form:errors>
            e.printStackTrace();
            throw new IllegalArgumentException("invalid date format. Please use this pattern\"" + datePattern + "\"");
        }
        return targetFormateDate;
    }
}
