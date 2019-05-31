package org.yuanxing.bootmvcannotation.fastjson;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2019-05-31 9:58
 * @see
 */

@Data
public class Word {
    private String d;
    private String e;
    private String f;
    private String a;
    private int b;
    private boolean c;
    private Date date;
    private Map<String,Object> map;
    private List<User> list;

}
