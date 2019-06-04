package org.yuanxing.bootmvcannotation.bean;

import lombok.*;

import java.util.Date;

/**
 * @author shkstart
 * @create 2019-06-04 16:15
 * @see
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Integer id;

    private String lastName;

    private String email;

    private Integer gender;

    private Department department;

    private Date birth;

    private Float salary;
}
