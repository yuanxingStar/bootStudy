package org.yuanxing.bootmvc.day2.editor;

import org.springframework.beans.propertyeditors.PropertiesEditor;

/**
 * @author shkstart
 * @create 2019-06-04 19:11
 * @see (1) Integer格式化器 将String类型格式化为Integer
 */
public class BootIntegerEditor extends PropertiesEditor {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.equals("")) {
            text = "0";
        }
        setValue(Integer.parseInt(text));
    }

    @Override
    public String getAsText() {
        return getValue().toString();
    }
}
