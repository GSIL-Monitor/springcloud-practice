package com.dianping.hui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: lanxinyu@meituan.com  2018-12-09 1:25 PM
 * @Description: Spring Cloud Sleuth与ELK配合使用
 */
@SpringBootApplication
public class ProviderUserTraceElkApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderUserTraceElkApplication.class, args);
    }
}
