package org.yuanxing.bootmvc.day2.editor;

import org.springframework.beans.propertyeditors.PropertiesEditor;

/**
 * @author shkstart
 * @create 2019-06-04 19:10
 * @see (1) Double类型格式化器 String类型格式化为Double
 */
public class BootDoubleEditor extends PropertiesEditor {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.equals("")) {
            text = "0";
        }
        setValue(Double.parseDouble(text));
    }

    @Override
    public String getAsText() {
        return getValue().toString();
    }
}
