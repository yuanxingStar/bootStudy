package org.yuanxing.bootiocbean.bean;

/**
 * @author shkstart
 * @create 2019-06-10 14:00
 * @see
 */
public class Yellow {

    private String name;
    private String value;

    public Yellow() {
    }

    public Yellow(String name,String value) {
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
