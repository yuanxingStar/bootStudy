package org.yuanxing.bootiocbean.bean;

/**
 * @author shkstart
 * @create 2019-06-10 14:07
 * @see
 */
public class Black {

    private String name;
    private String value;

    public Black() {
    }

    public Black(String name,String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
