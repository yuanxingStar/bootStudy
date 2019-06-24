package org.yuanxing.bootiocbean.bean;

/**
 * @author shkstart
 * @create 2019-06-10 13:55
 * @see
 */
public class Blue {
    private String name;
    private String value;

    public Blue() {
    }

    public Blue(String name,String value) {
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
