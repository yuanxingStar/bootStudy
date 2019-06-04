package org.yuanxing.bootmvcannotation.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author shkstart
 * @create 2019-06-03 10:08
 * @see (1) 自定义日期格式化器
 */


public class DatesFormatter  implements Formatter<Date> {
    private String datePattern;
    private SimpleDateFormat dateFormat;

    public DatesFormatter(){
        super();
    }

    public DatesFormatter(String datePattern) {
        this.datePattern = datePattern;
        dateFormat = new SimpleDateFormat(datePattern);
        dateFormat.setLenient(false);
        System.out.println("*********DatesFormatter*********   创建完毕");
    }

    @Override
    public String print(Date date, Locale locale) {
        return dateFormat.format(date);
    }

    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            // the error message will be displayed when using <form:errors>
            throw new IllegalArgumentException("invalid date format. Please use this pattern\"" + datePattern + "\"");
        }
    }

}
