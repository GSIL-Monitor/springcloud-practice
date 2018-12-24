package com.dianping.hui.entity;


import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: lanxinyu@meituan.com  2018-11-06 下午5:23
 * @Description:
 */
@Data
public class User {
    private Long id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;

}
