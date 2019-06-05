package org.yuanxing.bootmvc.day2.editor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shkstart
 * @create 2019-06-04 19:10
 * @see (1) 日期编辑器 将指定日期String 转化为 Date类型
 * */
public class BootDateEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(text);
        } catch (ParseException e) {
            format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = format.parse(text);
            } catch (ParseException e1) {
            }
        }
        setValue(date);
    }

    @Override
    public String getAsText() {
        return getValue().toString();
    }
}
