package com.dianping.hui.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: lanxinyu@meituan.com  2018-12-04 2:07 PM
 * @Description:
 */
@Data
public class User {
    Long id;
    String userName;
    String name;
    Integer age;
    BigDecimal balance;
}
